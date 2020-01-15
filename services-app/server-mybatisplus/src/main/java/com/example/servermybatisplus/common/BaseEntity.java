package com.example.servermybatisplus.common;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author: cowwa
 * @Date: 2019/12/5 16:35
 * @Description:
 */
@Data
public abstract class BaseEntity  {



    @TableField(exist=false)
    @JsonIgnore
    public Integer pageNo=1;

    @JsonIgnore
    @TableField(exist=false)
    public Integer pageSize=10;

    public Page builderPage(){
      return new Page(pageNo,pageSize);
    }

    public abstract QueryWrapper builderQueryWrapper();

}
