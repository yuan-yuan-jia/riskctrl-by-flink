package com.jyy.riskctrl.utils.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@Data
@ConfigurationProperties(prefix = "spring.redis.lettuce.pool")
public class RedisPoolProperties {

    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxActive;
    private Duration maxWait;


}
