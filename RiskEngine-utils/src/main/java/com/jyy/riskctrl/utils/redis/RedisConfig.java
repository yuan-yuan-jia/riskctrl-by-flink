package com.jyy.riskctrl.utils.redis;

import com.alibaba.fastjson2.support.spring.data.redis.GenericFastJsonRedisSerializer;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RedisConfig {
    @Autowired
    private RedisProperties redisProperties;
    @Autowired
    private RedisPoolProperties redisPoolProperties;

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

        // key,value 序列化配置
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericFastJsonRedisSerializer());

        // redis连接驱动配置
        redisTemplate.setConnectionFactory(lettuceConnectionFactory());

        return redisTemplate;
    }

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {

        Map<String, Object> map = new HashMap<>();
        map.put("spring.redis.cluster.nodes", redisProperties.getNodes());
        // Redis集群信息配置
        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration(
                new MapPropertySource("RedisClusterConfiguration", map)
        );

        // 客户端连接池
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMaxIdle(redisPoolProperties.getMaxIdle());
        genericObjectPoolConfig.setMinIdle(redisPoolProperties.getMinIdle());
        genericObjectPoolConfig.setMaxTotal(redisPoolProperties.getMaxActive());
        genericObjectPoolConfig.setMaxWait(redisPoolProperties.getMaxWait());


        LettucePoolingClientConfiguration lettucePoolingClientConfiguration = LettucePoolingClientConfiguration.builder().poolConfig(genericObjectPoolConfig).build();
        return new LettuceConnectionFactory(redisClusterConfiguration, lettucePoolingClientConfiguration);
    }

}
