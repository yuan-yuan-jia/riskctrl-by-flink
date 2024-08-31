package com.jyy.riskctrl.flink.Util;

import org.apache.flink.api.java.utils.ParameterTool;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ParameterUtilTest.class)
public class ParameterUtilTest {


    @Test
    void testGetParameters() throws Exception {

        String file = "flink.properties";
        ParameterTool parameterTool = ParameterUtil.getParameters(file);

        assertEquals("ImoocTest", parameterTool.get("imooc"));
    }
}
