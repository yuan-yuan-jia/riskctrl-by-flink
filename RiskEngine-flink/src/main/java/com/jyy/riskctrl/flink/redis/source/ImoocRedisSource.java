package com.jyy.riskctrl.flink.redis.source;

import com.jyy.riskctrl.flink.redis.conf.ImoocRedisCommand;
import com.jyy.riskctrl.flink.redis.conf.ImoocRedisDataType;
import com.jyy.riskctrl.flink.redis.conf.JedisBuilder;
import com.jyy.riskctrl.flink.redis.conf.JedisConf;
import com.jyy.riskctrl.model.RedisPO;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import redis.clients.jedis.JedisCluster;

/**
 * RichSourceFunction  富函数
 */
public class ImoocRedisSource extends RichSourceFunction<RedisPO> {

    private volatile boolean isRunning = true;

    private JedisBuilder jedisBuilder = null;

    private String redisKey = null;

    /**
     * Redis命令枚举对象
     */
    private ImoocRedisCommand imoocRedisCommand;



    public ImoocRedisSource(ImoocRedisCommand imoocRedisCommand, String redisKey) {
        this.imoocRedisCommand = imoocRedisCommand;
        this.redisKey = redisKey;
    }


    @Override
    public void run(SourceContext<RedisPO> sourceContext) throws Exception {

        /**
         * 一直监听Redis
         */

        //while (isRunning) {

            switch (imoocRedisCommand.getDataType()) {
                case STRING:
                    String data = jedisBuilder.get(redisKey);
                    sourceContext.collect(new RedisPO(data));
                    break;
            }


       // }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }

    @Override
    public void open(Configuration parameters) throws Exception {
        super.open(parameters);
        JedisCluster jedisCluster = JedisConf.getJedisCluster();
        jedisBuilder = new JedisBuilder(jedisCluster);
    }
}
