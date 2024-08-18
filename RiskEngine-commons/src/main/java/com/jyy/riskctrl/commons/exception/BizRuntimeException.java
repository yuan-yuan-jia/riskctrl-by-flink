package com.jyy.riskctrl.commons.exception;

/**
 * Java 将所有的错误封装为一个对象
 * 所有的错误的根对象 Throwable, Throwable有两个子类: Error和Exception
 *
 * Error: 应用程序无法处理的错误
 * Exception: 应用程序可以处理的错误
 *
 * RuntimeException: 运行错误，编译器不会检查这种错误
 * 非RuntimeException: 编译错误，在编译阶段就能够捕获这个错误
 */

import com.jyy.riskctrl.commons.exception.enums.BizExceptionInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * 自定义异常的根类
 */
@Slf4j
public class BizRuntimeException extends RuntimeException {

    public BizRuntimeException(BizExceptionInfo info) {
        log.error(info.getExceptionMsg());
    }

}
