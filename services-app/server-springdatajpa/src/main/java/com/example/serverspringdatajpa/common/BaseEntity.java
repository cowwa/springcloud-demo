package com.example.serverspringdatajpa.common;

import com.querydsl.core.BooleanBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author: cowwa
 * @Date: 2019/12/5 16:35
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BaseEntity  {

    public abstract BooleanBuilder builderQuery();

}
