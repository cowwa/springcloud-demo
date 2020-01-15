package com.example.servermybatisplus.service;

import com.example.servermybatisplus.entity.Personal;
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
public interface IPersonalService extends IService<Personal> {
    public void dataDumpRecord(List<Personal> personalList);
}
