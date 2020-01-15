package com.example.servicescore.response;

/**
 * @author: cowwa
 * @Date: 2019/12/16 16:34
 * @Description: 常用错误枚举
 */

public enum ResponseCode {

    SUCCESS("200"),

    ERROR("90000"),

    SYSTEM_ERROR("500"),

    VALID_ERROR("412"),

    BUSSINESS_ERROR("20001"),

    PARAM_ERROR("20002");

    private String code;

    ResponseCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
