package com.jyy.riskctrl.utils.hbase;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = "hbase.conf")
public class HbaseProperties {

    private Map<String, String> confMaps;

}
