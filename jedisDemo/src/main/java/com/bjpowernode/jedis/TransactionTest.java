package com.bjpowernode.jedis;

import com.bjpowernode.util.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Jedis实现事务的操作
 */
public class TransactionTest {
    public static void main(String[] args) {
        //1. （从JedisPool中）获取/创建Jedis对象
        JedisPool jedisPool = RedisUtils.open("192.168.174.111", 6379); //jedisPool连接池对象
        //2. 从连接池对象中获取一个Jedis的连接对象
        Jedis jedis = jedisPool.getResource();
        jedis.flushDB();
        //3. 开启事务
        Transaction trans = jedis.multi();
        //4. 事务中的代码
        trans.set("str4","ddd");
        trans.set("str5","eee");
        List<Object> exec = trans.exec();
        for (Object o : exec) {
            System.out.println(o);
        }

        jedisPool.close();
    }
}
