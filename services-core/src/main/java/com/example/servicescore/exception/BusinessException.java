package com.example.servicescore.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: cowwa
 * @Date: 2019/12/17 11:07
 * @Description:
 */
@Data
public class BusinessException extends Exception {

    @ApiModelProperty(value = "返回码")
    private String code;

    /**
     * 默认为一般信息
     */
    private ExceptionLevel level=ExceptionLevel.IGNORE;

    private Object[] args;


    public BusinessException(String code){
        this.code=code;
    }

    /**
     * 带占位符消息
     * @param code
     * @param args
     */
   public BusinessException(String code,Object[] args){
        this.code=code;
        this.args=args;
   }

    /**
     * 自定义消息级别
     * @param code
     * @param level
     */
   public BusinessException(String code,ExceptionLevel level){
       this.code=code;
       this.level=level;
   }

    /**
     * 带占位符消息及定义消息级别
     * @param code
     * @param args
     * @param level
     */
   public BusinessException(String code,Object[] args,ExceptionLevel level){
        this.code=code;
        this.args=args;
        this.level=level;
    }


}
