package com.example.serverbusgateway;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: cowwa
 * @Date: 2019/12/16 16:30
 * @Description: 定义统一返回
 */
@Data
public class ResponseData<T> implements Serializable {
    @ApiModelProperty(value = "返回码")
    private String code;
    @ApiModelProperty(value = "返回消息")
    private String msg;
    @ApiModelProperty(value = "返回实体")
    private T data;

    public ResponseData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseData(String code) {
        this.code = code;
    }


    public ResponseData() {
    }
}
