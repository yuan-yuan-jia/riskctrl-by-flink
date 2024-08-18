package com.jyy.riskctrl.utils.json;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * 基于fastjson2
 */
public class JsonUtils {

    /**
     * 序列化是将对象转换为字节序列的过程，序列化的对象可以在
     * 网络中传输
     * Json就是将对象转换为Json字符串
     *
     *Json字符串和对象之间的转换
     */


    public static String obj2JsonStr(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T jsonStr2Object(String jsonStr, Class<T> t) {
        return JSON.parseObject(jsonStr, t);
    }

    /**
     *
     * 有如下格式
     * "{'颜色': '黑色','规格':'16GB'}"
     * "{'颜色': '白色','规格':'16GB'}"
     */
    public static <K,V> Map<K,List<V>> jsonStr2Map(String str, Class<K> keyType, Class<V> valueType ) {

        return JSON.parseObject(str, new TypeReference<Map<K,List<V>>>(keyType, valueType){});
    }

    /*
        [{'颜色': '黑色','规格':'16GB'},{'颜色': '白色','规格':'16GB'}]
     */
    public static <T> List<T> jsonStr2List(String json,Class<T> itemType) {
        return JSON.parseArray(json,itemType);
    }
}
