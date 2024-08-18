package com.jyy.riskctrl.api.exception;

import com.jyy.riskctrl.commons.exception.custom.RedisException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Api接口全局异常捕获类
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = RedisException.class)
    public void RedisExceptionHandler(RedisException e) {
        //TODO
        
    }
}
