package com.jyy.riskctrl.flink;

import org.apache.flink.api.common.functions.MapFunction;

/*
   MapFunction测试
 */
public class TestMapFunction implements MapFunction<String, String> {

    @Override
    public String map(String s) throws Exception {
        // 两个字符串的拼接
        return "hello " + s;
    }
}
