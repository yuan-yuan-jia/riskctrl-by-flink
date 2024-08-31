package com.jyy.riskctrl.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Redis数据的映射对象
 */
@Data
public class RedisPO implements Serializable {

    private String data;

    public RedisPO(String data) {
        this.data = data;
    }

    public RedisPO() {

    }

}
