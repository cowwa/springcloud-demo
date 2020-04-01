package com.example.servermybatisplus.service.impl;

import com.example.servermybatisplus.entity.CaseFollowupRecord;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.servermybatisplus.mapper.CaseFollowupRecordMapper;
import com.example.servermybatisplus.service.ICaseFollowupRecordService;
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
 * @since 2019-12-06
 */
@Service
public class CaseFollowupRecordServiceImpl extends ServiceImpl<CaseFollowupRecordMapper, CaseFollowupRecord> implements ICaseFollowupRecordService {

    private Logger logger= LoggerFactory.getLogger(CaseFollowupRecordServiceImpl.class);
    @Async("asyncServiceExecutor")
    public void dataDumpRecord(List<CaseFollowupRecord> list) {
        logger.info("保存开始.............");
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        saveBatch(list,20000);
        stopWatch.stop();
        logger.info("保存耗时:{}",stopWatch.getTotalTimeMillis());
    }

}
