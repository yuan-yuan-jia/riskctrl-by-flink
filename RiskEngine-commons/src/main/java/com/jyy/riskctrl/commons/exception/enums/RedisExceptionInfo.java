package com.jyy.riskctrl.commons.exception.enums;

import lombok.Getter;

@Getter
public enum RedisExceptionInfo implements BizExceptionInfo{


    REDIS_TEMPLATE_NULL("-300", "RedisTemplate对象为null");

    private final String exceptionCode;
    private final String exceptionMsg;

    RedisExceptionInfo(String exceptionCode,
                       String exceptionMsg
                       ) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }

}
