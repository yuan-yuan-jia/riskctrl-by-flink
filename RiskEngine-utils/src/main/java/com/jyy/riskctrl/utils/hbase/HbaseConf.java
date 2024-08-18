package com.jyy.riskctrl.utils.hbase;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/*
  EnableConfigurationProperties将ConfigurationProperties修饰的类加入进IOC容器
 */
@Configuration
@EnableConfigurationProperties(HbaseProperties.class)
public class HbaseConf {

    @Autowired
    private HbaseProperties hbaseProperties;


    public org.apache.hadoop.conf.Configuration configuration() {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        Map<String, String> confMaps = hbaseProperties.getConfMaps();
        confMaps.forEach(conf::set);
        return conf;
    }

}
