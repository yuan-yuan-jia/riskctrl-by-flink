package com.jyy.riskctrl.flink.redis.conf;

import com.jyy.riskctrl.flink.Util.ParameterUtil;
import org.apache.flink.api.java.utils.ParameterTool;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.IOException;

/**
 * JedisConf
 */
public class JedisConf {


    public static JedisCluster getJedisCluster() throws IOException {
        ParameterTool parameterTool = ParameterUtil.getParameters("flink.properties");

        String redisHost = parameterTool.get("redis.host");
        String redisPort = parameterTool.get("redis.port");


        /**
         * Jedis对象：
         *
         * JedisPool：用于redis单机版
         * JedisCluster: 用于redis集群
         */

        HostAndPort hostAndPort = new HostAndPort(redisHost, Integer.parseInt(redisPort));

        return new JedisCluster(hostAndPort);
    }

}
