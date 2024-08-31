package com.jyy.riskctrl.flink.redis.sink;


/**
 * 基于apache bahir flink的RedisSink，操作Redis String类型
 */

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;

/**
 * redis的数据类型
 * 1. String
 * 2. Hash
 * 3. List
 * 4. Set
 * 5. z-zSet
 */
public class RedisSinkByBahirWithString implements RedisMapper<Tuple2<String, String>> {


    /**
     * 指定Redis的命令
     * @return
     */

    @Override
    public RedisCommandDescription getCommandDescription() {
        return new RedisCommandDescription(RedisCommand.SET);
    }

    /**
     * 从数据流里获取Key值
     * @param stringStringTuple2
     * @return
     */
    @Override
    public String getKeyFromData(Tuple2<String, String> stringStringTuple2) {
        return stringStringTuple2.f0;
    }


    /**
     * 从数据流里获取Value值
     * @param stringStringTuple2
     * @return
     */
    @Override
    public String getValueFromData(Tuple2<String, String> stringStringTuple2) {
        return stringStringTuple2.f1;
    }
}
