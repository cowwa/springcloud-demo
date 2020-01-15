package com.example.servermybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.servermybatisplus.entity.Personal;
import com.example.servermybatisplus.mapper.PersonalMapper;
import com.example.servermybatisplus.service.IPersonalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cowwa
 * @since 2019-12-09
 */
@Service
public class PersonalServiceImpl extends ServiceImpl<PersonalMapper, Personal> implements IPersonalService {
   /* @Autowired
    ElasticsearchTemplate elasticsearchTemplate;*/

    private Logger logger = LoggerFactory.getLogger(PersonalServiceImpl.class);

    @Async
    public void dataDumpRecord(List<Personal> personalList) {
        logger.info("P保开始.........");
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        saveBatch(personalList);
        stopWatch.stop();
        logger.info("P保存耗时:{}",stopWatch.getTotalTimeMillis());
    }



}
