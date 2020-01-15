package com.example.servicescore.exception;



import com.example.servicescore.component.MessageSourceHandler;
import com.example.servicescore.response.ResponseCode;
import com.example.servicescore.response.ResponseData;
import com.example.servicescore.response.ResponseDataUtil;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @author: cowwa
 * @Date: 2019/12/17 11:30
 * @Description: 全局异常信息处理
 */
@Slf4j
public class GlobalExceptionHandler {



    @Autowired
    MessageSourceHandler messageSourceHandler;

    /**
     * 系统异常信息
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseData errorHandler(Exception e){
        log.error(e.getMessage(),e);
        return ResponseDataUtil.buildError(ResponseCode.SYSTEM_ERROR.getCode(),handleErrorException(e.getMessage(),null));
    }

    /**
     * Valid检验异常信息
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseData validExceptionHandler(MethodArgumentNotValidException e){
        log.error(e.getMessage(),e);
        BindingResult result = e.getBindingResult();
        StringBuilder errorMsg = new StringBuilder() ;

        if (result.hasErrors()) {
            List<FieldError> fieldErrors = result.getFieldErrors();
            fieldErrors.forEach(error -> errorMsg.append(error.getDefaultMessage()).append("&"));
        }
        return ResponseDataUtil.buildError(ResponseCode.VALID_ERROR.getCode(),errorMsg.toString());
    }

    /**
     * 自定义异常信息
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseData businessExceptionHandler(BusinessException e){
        log.error(e.getCode(),e);
        return ResponseDataUtil.buildError(e.getCode(),handleErrorException(e.getCode(),e.getArgs()));
    }

    /**
     * 获取具体的信息
     * @param code
     * @param args
     * @return
     */
    private String handleErrorException(String code,Object[] args) {
        String msg = code;
        try {
            if (Strings.isNullOrEmpty(code)) {
                msg = messageSourceHandler.getMessage(ResponseCode.SYSTEM_ERROR.getCode(),null);
            }else {
                msg = messageSourceHandler.getMessage(code,args);
            }
        }catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return msg;
    }


}
