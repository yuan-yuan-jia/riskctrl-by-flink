package com.jyy.riskctrl.utils.redis;

import com.jyy.riskctrl.utils.Application;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RedisUtilTest {

    @Autowired
    private RedisUtil redisUtil;

    @DisplayName("测试redis set")
    @Test
    @Order(1)
    void testStringSet() {
        redisUtil.stringSet("immooc:set", "this is test");
    }



    @DisplayName("测试redis get")
    @Test
    @Order(2)
    void testStringGet() {
        Object o = redisUtil.stringGet("immooc:set");
        System.out.println(o);
    }

    @DisplayName("测试redis hash set")
    @Test
    @Order(1)
    void testHashSet() {
        Map<String, Object> map = new HashMap<>();
        map.put("key","value");
        redisUtil.hashSet("imooc:set:hash", map);
    }

    @DisplayName("测试redis hash set")
    @Test
    @Order(2)
    void testHashGet() {

        Object o = redisUtil.hashGet("imooc:set:hash", "key");
        System.out.println(o);
    }
}
