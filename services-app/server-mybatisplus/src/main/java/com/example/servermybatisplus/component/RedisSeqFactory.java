package com.example.servermybatisplus.component;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @author: cowwa
 * @Date: 2019/12/19 14:46
 * @Description: 利用redis生成全局唯一主键
 */
@Slf4j
@Component
public class RedisSeqFactory {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private final  static  String seqCode="mybatisPlusSeqNo";

    /**
     * @Title: getTodayEndTime
     * @Description: Get the cache expire time.
     * @return
     */
    private static Date getTodayEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 生成全局的序列号总长20位，前8位为每日日期，后12位顺序号，每日重复(格式为yyyyMMdd)
     * @return
     */
    public  String generateSeq() {
        RedisAtomicLong counter = new RedisAtomicLong(seqCode, stringRedisTemplate.getConnectionFactory());
        counter.expireAt(getTodayEndTime());
        return new SimpleDateFormat("yyyyMMdd").format(new Date())
                .concat(Strings.padStart(String.valueOf(counter.incrementAndGet()),12,'0'));
    }

    /**
     * 自定义序号
     * @param key 主键
     * @param expireTime 过期时间
     * @param prefixStr 序号前缀
     * @param length 序号长度
     * @return
     */
    public String generate(String key,Date expireTime,String prefixStr,int length) {
        RedisAtomicLong counter = new RedisAtomicLong(key, stringRedisTemplate.getConnectionFactory());
        if(Objects.nonNull(expireTime)){
            counter.expireAt(expireTime);
        }
        if(!Strings.isNullOrEmpty(prefixStr)){
            return prefixStr.concat(Strings.padStart(String.valueOf(counter.incrementAndGet()),length,'0'));
        }else {
            return Strings.padStart(String.valueOf(counter.incrementAndGet()),length,'0');
        }
    }
}
