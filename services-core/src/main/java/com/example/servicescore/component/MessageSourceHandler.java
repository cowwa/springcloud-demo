package com.example.servicescore.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: cowwa
 * @Date: 2019/12/17 10:21
 * @Description: 国际化处理类
 */
@Component
public class MessageSourceHandler {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MessageSource messageSource;

    /**
     * 由客户端来决定请求语言
     * @param messageKey
     * @return
     */
    public String getMessage(String messageKey,Object[] args) {
        String message = messageSource.getMessage(messageKey, args, RequestContextUtils.getLocale(request));
        return message;
    }


    /**
     * 由部署服务器决定语言
     * @param messageKey
     * @return
     */
 /*   public String getMessage(String messageKey) {
        String message = messageSource.getMessage(messageKey, null, LocaleContextHolder.getLocale());
        return message;
    }*/


}
