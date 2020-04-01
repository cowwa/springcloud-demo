package com.example.servermybatisplus.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.servermybatisplus.entity.BaseCase;
import com.example.servermybatisplus.mapper.BaseCaseMapper;
import com.example.servermybatisplus.service.IBaseCaseService;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2020-03-20
 */
@Service
@Slf4j
public class BaseCaseServiceImpl extends ServiceImpl<BaseCaseMapper, BaseCase> implements IBaseCaseService {

    @Async("asyncServiceExecutor")
    @Override
    public void dataDumpRecord(List<BaseCase> list) {
            log.info("Base保存开始.............");
            StopWatch stopWatch=new StopWatch();
            stopWatch.start();
            saveBatch(list,20000);
            stopWatch.stop();
        log.info("Base保存耗时:{}",stopWatch.getTotalTimeMillis());

    }
}
