package com.example.servicescore;

import com.example.servicescore.component.MessageSourceHandler;
import com.example.servicescore.response.ResponseCode;
import com.example.servicescore.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author: cowwa
 * @Date: 2019/12/5 16:35
 * @Description:
 */

public class BaseController {

    @Autowired
    MessageSourceHandler messageSourceHandler;

    @Autowired
    HttpSession httpSession;


    /**
     * 获取spring session
     * @return
     */
    public HttpSession getHttpSession(){
        return  httpSession;
    }
    /**
     * 成功无数据返回
     * @return
     */
    public ResponseData resSuccess() {
        return new ResponseData(ResponseCode.SUCCESS.getCode(),
                messageSourceHandler.getMessage(ResponseCode.SUCCESS.getCode(),null));
    }



    /**
     * 成功返回数据对象
     * @param data
     * @param <T>
     * @return
     */
    public  <T> ResponseData resSuccess(T data) {
        return new ResponseData<T>(ResponseCode.SUCCESS.getCode(),
                messageSourceHandler.getMessage(ResponseCode.SUCCESS.getCode(),null), data);
    }

    /**
     * 成功有消息提示
     * @param args
     * @return
     */
    public  ResponseData resSuccess(String code,Object[] args) {
        return new ResponseData(code,
                messageSourceHandler.getMessage(code,args));
    }

    /**
     *
     * @param code
     * @param args
     * @param data
     * @param <T>
     * @return 成功自定义消息码和消息内容及相应得到数据
     */
    public  <T> ResponseData resSuccess(String code, Object[] args, T data) {
        return new ResponseData<T>(code,
                messageSourceHandler.getMessage(code,args),
                data);
    }

    /**
     * 返回默认的错误码
     * @return
     */
    public  ResponseData resFail() {
        return new ResponseData(ResponseCode.ERROR.getCode(),
                messageSourceHandler.getMessage(ResponseCode.ERROR.getCode(),null));
    }

    /**
     * 返回错误码及自定义的错误消息
     * @param args
     * @return
     */
    public  ResponseData resFail(Object[] args) {
        return new ResponseData(ResponseCode.ERROR.getCode(),
                messageSourceHandler.getMessage(ResponseCode.ERROR.getCode(),args));
    }

    /**
     * 自定义先返回码及提示信息
     * @param code
     * @param args
     * @return
     */
    public  ResponseData resFail(String code,Object[] args) {
        return new ResponseData(code,
                messageSourceHandler.getMessage(code,args));
    }


    /**
     *
     * @param code
     * @param args
     * @param data
     * @param <T>
     * @return 失败自定义消息码和消息内容及相应得到数据
     */
    public  <T> ResponseData resFail(String code, Object[] args, T data) {
        return new ResponseData<T>(code,
                messageSourceHandler.getMessage(code,args),
                data);
    }





}
