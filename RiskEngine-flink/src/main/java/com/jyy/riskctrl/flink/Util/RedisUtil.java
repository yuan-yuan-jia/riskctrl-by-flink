package com.jyy.riskctrl.flink.Util;

import com.jyy.riskctrl.flink.redis.conf.ImoocRedisCommand;
import com.jyy.riskctrl.flink.redis.sink.RedisSinkByBahirWithString;
import com.jyy.riskctrl.flink.redis.source.ImoocRedisSource;
import com.jyy.riskctrl.model.RedisPO;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.redis.RedisSink;
import org.apache.flink.streaming.connectors.redis.common.config.FlinkJedisClusterConfig;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashSet;

public class RedisUtil {


    private static FlinkJedisClusterConfig jedisClusterConfig = null;

    static {
        try {
            ParameterTool parameterTool = ParameterUtil.getParameters("flink.properties");
            String redisHost = parameterTool.get("redis.host");
            String redisPort = parameterTool.get("redis.port");

            /**
             * InetSocketAddress:Java的套接字
             */
            InetSocketAddress redisInetSocketAddress = new InetSocketAddress(redisHost, Integer.parseInt(redisPort));
            HashSet<InetSocketAddress> set = new HashSet<>();
            set.add(redisInetSocketAddress);
            jedisClusterConfig = new FlinkJedisClusterConfig.Builder()
                    .setNodes(set)
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     *写入redis的字符串类型，基于bahir
     */
    public static void writeByBahirWithString(DataStream<Tuple2<String, String>> input) {

        input.addSink(new RedisSink<>(jedisClusterConfig, new RedisSinkByBahirWithString()));

    }


    /**
     *读取redis的字符串类型
     */
    public static DataStream<RedisPO> read(StreamExecutionEnvironment env, ImoocRedisCommand imoocRedisCommand, String key) {
        return env.addSource(new ImoocRedisSource(imoocRedisCommand,key));
    }


}
