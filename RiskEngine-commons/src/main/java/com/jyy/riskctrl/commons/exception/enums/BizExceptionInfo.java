package com.jyy.riskctrl.commons.exception.enums;

/**
 * 异常枚举类接口
 */
public interface BizExceptionInfo {

    // 获取异常错误码
    String getExceptionCode();

    // 获取异常信息
    String getExceptionMsg();
}
