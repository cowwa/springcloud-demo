package com.example.servermybatisplus.service;

import com.example.servermybatisplus.entity.PersonalPerCall;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cowwa
 * @since 2019-12-09
 */
public interface IPersonalPerCallService extends IService<PersonalPerCall> {
    public void dataDumpRecord(List<PersonalPerCall> list);
}
