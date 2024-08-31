package com.jyy.riskctrl.flink.utils;

import com.jyy.riskctrl.flink.Util.RedisUtil;
import com.jyy.riskctrl.flink.redis.conf.ImoocRedisCommand;
import com.jyy.riskctrl.flink.redis.conf.ImoocRedisDataType;
import com.jyy.riskctrl.model.RedisPO;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RedisUtilTest {


    @DisplayName("测试基于Bahir写入Redis，Redis数据类型是String类型")
    @Test
    void testWriteByBahirWithString() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Tuple2<String, String> tuple = Tuple2.of("immoc-bahir", "this is written by bahir");

        DataStreamSource<Tuple2<String, String>> dataStream = env.fromElements(tuple);

        RedisUtil.writeByBahirWithString(dataStream);

        env.execute();
    }



    @DisplayName("测试基于Bahir写入Redis，Redis数据类型是String类型")
    @Test
    void testReadByCustomSourceWithString() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<RedisPO> read = RedisUtil.read(env, ImoocRedisCommand.GET, "immoc-bahir");
        read.print();
        env.execute();
    }


}
