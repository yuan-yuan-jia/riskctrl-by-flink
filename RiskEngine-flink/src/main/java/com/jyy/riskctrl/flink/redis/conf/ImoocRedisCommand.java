package com.jyy.riskctrl.flink.redis.conf;

/**
 * Redis命令枚举类
 */
public enum ImoocRedisCommand {

    GET(ImoocRedisDataType.STRING);


    private ImoocRedisDataType dataType;

    ImoocRedisCommand(ImoocRedisDataType dataType) {
        this.dataType = dataType;
    }


    public ImoocRedisDataType getDataType() {
        return dataType;
    }
}
