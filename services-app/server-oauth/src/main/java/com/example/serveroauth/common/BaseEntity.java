package com.example.serveroauth.common;

import com.querydsl.core.BooleanBuilder;
import lombok.Data;

/**
 * @author: cowwa
 * @Date: 2019/12/5 16:35
 * @Description:
 */
@Data
public abstract class BaseEntity  {

    public abstract BooleanBuilder builderQuery();

}
