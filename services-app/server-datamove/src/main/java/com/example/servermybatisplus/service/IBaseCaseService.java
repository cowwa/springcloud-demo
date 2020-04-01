package com.example.servermybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.servermybatisplus.entity.BaseCase;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cowwa
 * @since 2020-03-20
 */
public interface IBaseCaseService extends IService<BaseCase> {

    void dataDumpRecord(List<BaseCase> list);

}
