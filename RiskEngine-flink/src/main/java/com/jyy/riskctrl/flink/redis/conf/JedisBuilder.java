package com.jyy.riskctrl.flink.redis.conf;


import redis.clients.jedis.JedisCluster;

/**
 * 封装Jedis对象的redis方法
 */
public class JedisBuilder {

   private JedisCluster jedis = null;

   public JedisBuilder(JedisCluster jedisCluster) {
       this.jedis = jedisCluster;
   }


   public void close() {
       if (this.jedis != null) {
           this.jedis.close();
       }
   }

   public String get(String key) {
       return this.jedis.get(key);
   }

}
