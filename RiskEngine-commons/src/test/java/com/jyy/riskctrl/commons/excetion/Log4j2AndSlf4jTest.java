package com.jyy.riskctrl.commons.excetion;

import com.jyy.riskctrl.commons.exception.Log4j2AndSlf4jDemo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Log4j2AndSlf4jTest.class)
public class Log4j2AndSlf4jTest {

    @DisplayName("Slf4j日志输出")
    @Test
    void testSlf4jOutput() {
        Log4j2AndSlf4jDemo.slf4jOutput();
    }

    @DisplayName("log4j2日志输出")
    @Test
    void testLog4jOutput() {
        Log4j2AndSlf4jDemo.log4j2Output();
    }
}
