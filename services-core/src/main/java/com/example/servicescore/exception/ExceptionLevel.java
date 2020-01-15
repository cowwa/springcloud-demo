package com.example.servicescore.exception;

/**
 * @author: cowwa
 * @Date: 2019/12/17 10:59
 * @Description: 异常信息等级分类
 */
public enum ExceptionLevel {
    /**
     * high level,需要紧急处理的
     */
    HIGH(3),
    /**
     * normal level,需要统一采集分析的
     */
    NORMAL(2),
    /**
     * ignore level,一般的用于展示
     */
    IGNORE(1);



    private int level;

    ExceptionLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

}
