package com.jyy.riskctrl.commons.excetion;

import com.jyy.riskctrl.commons.exception.CustomExceptionDemo;
import com.jyy.riskctrl.commons.exception.custom.RedisException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = CustomExceptionTest.class)
public class CustomExceptionTest {

    @DisplayName("测试自定义异常捕获")
    @Test
    public void testThrowCustomException() {
        Throwable thrown = assertThrows(
                RedisException.class,
                CustomExceptionDemo::throwCustomException
        );
        System.out.println("thrown数据类型: " + thrown);
    }
}
