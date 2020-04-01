package com.example.servermybatisplus.service;

import com.example.servermybatisplus.entity.CaseFollowupRecord;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cowwa
 * @since 2019-12-06
 */
public interface ICaseFollowupRecordService extends IService<CaseFollowupRecord> {
     void dataDumpRecord(List<CaseFollowupRecord> list);
}
