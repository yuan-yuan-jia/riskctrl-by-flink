package com.jyy.riskctrl.commons.exception;

import com.jyy.riskctrl.commons.exception.custom.RedisException;
import com.jyy.riskctrl.commons.exception.enums.RedisExceptionInfo;

public class CustomExceptionDemo {

    public static void throwCustomException() throws RedisException {
        throw new RedisException(RedisExceptionInfo.REDIS_TEMPLATE_NULL);
    }
}
