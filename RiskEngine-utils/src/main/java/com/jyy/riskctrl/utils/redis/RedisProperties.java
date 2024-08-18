package com.jyy.riskctrl.utils.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "spring.redis.cluster")
@Component
@Data
public class RedisProperties {

    // 集群节点列表
    private String nodes;
}
