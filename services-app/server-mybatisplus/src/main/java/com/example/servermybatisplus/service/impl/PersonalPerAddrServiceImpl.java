package com.example.servermybatisplus.service.impl;

import com.example.servermybatisplus.entity.Personal;
import com.example.servermybatisplus.entity.PersonalPerAddr;
import com.example.servermybatisplus.entity.PersonalPerCall;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.servermybatisplus.mapper.PersonalPerAddrMapper;
import com.example.servermybatisplus.service.IPersonalPerAddrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cowwa
 * @since 2019-12-09
 */
@Service
public class PersonalPerAddrServiceImpl extends ServiceImpl<PersonalPerAddrMapper, PersonalPerAddr> implements IPersonalPerAddrService {
    private Logger logger= LoggerFactory.getLogger(PersonalPerAddrServiceImpl.class);

    @Async("asyncServiceExecutor")
    public void dataDumpRecord(List<PersonalPerAddr> list) {
        logger.info("addr保开始.........");
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        saveBatch(list);
        stopWatch.stop();
        logger.info("Addr保存耗时:{}",stopWatch.getTotalTimeMillis());
    }
}
