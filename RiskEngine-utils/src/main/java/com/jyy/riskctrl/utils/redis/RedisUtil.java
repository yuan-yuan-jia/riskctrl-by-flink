package com.jyy.riskctrl.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void stringSet(String key,Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object stringGet(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void hashSet(String key, Map<String,Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    public Object hashGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

}
