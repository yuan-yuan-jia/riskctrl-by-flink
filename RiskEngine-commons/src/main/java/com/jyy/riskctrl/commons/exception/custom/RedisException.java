package com.jyy.riskctrl.commons.exception.custom;

import com.jyy.riskctrl.commons.exception.BizRuntimeException;
import com.jyy.riskctrl.commons.exception.enums.BizExceptionInfo;

public class RedisException extends BizRuntimeException {

    public RedisException(BizExceptionInfo info) {
        super(info);
    }
}
