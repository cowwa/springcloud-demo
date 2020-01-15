package com.example.servicescore.response;
/**
 * @author: cowwa
 * @Date: 2019/12/16 16:34
 * @Description: 返回结果工具类
 */
public class ResponseDataUtil {

    /**
     * 成功无数据返回
     * @return
     */
    public static ResponseData buildSuccess() {
        return new ResponseData(ResponseCode.SUCCESS.getCode());
    }


    /**
     * 成功返回数据对象
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseData buildSuccess(T data) {
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode(), data);
    }

    /**
     * 成功有消息提示
     * @param msg
     * @return
     */
    public static ResponseData buildSuccess(String msg) {
        return new ResponseData(ResponseCode.SUCCESS.getCode(), msg);
    }

    /**
     * 成功自定义消息码和消息内容
     * @param code
     * @param msg
     * @return
     */
    public static ResponseData buildSuccess(String code, String msg) {
        return new ResponseData(code, msg);
    }

    /**
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return 成功自定义消息码和消息内容及相应得到数据
     */
    public static <T> ResponseData buildSuccess(String code, String msg, T data) {
        return new ResponseData<T>(code, msg, data);
    }



    /**
     * 失败，返回相应的失败数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponseData buildError(T data) {
        return new ResponseData<T>(ResponseCode.ERROR.getCode(), data);
    }

    /**
     * 返回默认的错误码
     * @return
     */
    public static ResponseData buildError() {
        return new ResponseData(ResponseCode.ERROR.getCode());
    }

    /**
     * 返回错误码及自定义的错误消息
     * @param msg
     * @return
     */
    public static ResponseData buildError(String msg) {
        return new ResponseData(ResponseCode.ERROR.getCode(), msg);
    }

    /**
     * 返回错误的编码及错误的消息
     * @param code
     * @param msg
     * @return
     */
    public static ResponseData buildError(String code, String msg) {
        return new ResponseData(code, msg);
    }

    /**
     *
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return 返回错误的编码及错误的消息、错误的实体数据
     */
    public static <T> ResponseData buildError(String code, String msg, T data) {
        return new ResponseData<T>(code, msg, data);
    }
}
