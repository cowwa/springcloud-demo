package com.example.serverspringdatajpa.common;

import com.example.servicescore.exception.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author: cowwa
 * @Date: 2019/12/31 16:40
 * @Description:
 */
@Slf4j
@RestControllerAdvice()
public class AppExceptionHandler extends GlobalExceptionHandler {
}
