package com.bjpowernode.jedis;

import redis.clients.jedis.Jedis;

/**
 * 使用Jedis操作Redis
 */
public class JedisTest {

    public static void main(String[] args) {
        // 创建Jedis对象
        Jedis jedis = new Jedis("192.168.174.111",6379);
        String str1 = jedis.get("str1");
        String str2 = jedis.get("str2");

        jedis.lpush("list1","a","b","c");
        String l1 = jedis.lindex("list1", 0);

        System.out.println("str1:"+str1);
        System.out.println("str2:"+str2);
        System.out.println("list1索引0位置的元素是:"+l1);

        // 关闭jedis
        jedis.close();
    }
}
