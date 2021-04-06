package com.bjpowernode.jedis;

import com.bjpowernode.util.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 使用JedisPool操作redis
 */
public class JedisPoolTest {

    public static void main(String[] args) {
        //1. 通过工具类来获取连接池对象
        JedisPool jedisPool = RedisUtils.open("192.168.174.111", 6379);
        //2. 从连接池中获取一个Jedis对象
        Jedis jedis = jedisPool.getResource();
        // 清空数据库
        jedis.flushAll();
        jedis.mset("str1","a1","str2","b1","str3","c1");

        String str1 = jedis.get("str1");
        System.out.println(str1);

        // 关闭jedis
        jedisPool.close();

    }
}
