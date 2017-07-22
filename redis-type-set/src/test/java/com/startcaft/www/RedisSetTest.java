package com.startcaft.www;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisSetTest {

    private Jedis jedis;

    private static final String SET_KEY = "set-key";

    @Before
    public void initJedis(){
        jedis = JedisUtils.getInstance().getJedis(JedisUtils.ipAddr,JedisUtils.port);
        System.out.println("清空数据当前数据库(默认数据库下标为[0])："+jedis.flushDB());
    }

    @After
    public void closeJedis(){
        JedisUtils.getInstance().closeJedis(jedis,JedisUtils.ipAddr,JedisUtils.port);
    }

    @Test

    public void testSetBasic(){
        {
            Long result = jedis.sadd(SET_KEY,"a","b","c");
            System.out.println("向Set中添加元素，返回的是原本不存在于Set中的元素的个数：" + result);

            result = jedis.srem(SET_KEY,"c","d");//d不存在于Set中
            System.out.println("移除Set中的元素，，删除存在的元素，并返回的是存在于Set中的元素的个数：" + result);

            result = jedis.scard(SET_KEY);
            System.out.println("获取Set中元素的总数：" + result);

            //set["a","b"]
            Set<String> set = jedis.smembers(SET_KEY);
            set.forEach(System.out::println);


            //移动一个存在的元素到另外一个集合
            result = jedis.smove(SET_KEY,SET_KEY + "1","a");
            System.out.println("把原始集合的一个元素移动到目标集合中，原始集合的元素被删除，返回的结果是：" + result);

            //移动一个不存在的元素到另外一个集合
            result = jedis.smove(SET_KEY,SET_KEY + "1","c");
            System.out.println("把原始集合的一个元素移动到目标集合中，但是这个元素并不存在，返回的结果是：" + result);

            //set[,"b"]
            set = jedis.smembers(SET_KEY);
            set.forEach(System.out::println);
        }
    }


    @Test
    public void testMulSet(){
        {
            //先初始化两个set
            jedis.sadd(SET_KEY,"a","b","c","d");
            jedis.sadd(SET_KEY + "1","c","d","e","f");

            //计算两个set的差集["a","b"]
            Set<String> sets = jedis.sdiff(SET_KEY,SET_KEY + "1");
            System.out.println("两个集合的差集是：");
            sets.forEach(System.out::println);

            //计算两个set的交集["c","d"]
            sets = jedis.sinter(SET_KEY,SET_KEY + "1");
            System.out.println("两个集合的交集是：");
            sets.forEach(System.out::println);

            //计算两个set的交集["a","b","c","d","e","f"]，排序有所不同
            sets = jedis.sunion(SET_KEY,SET_KEY + "1");
            System.out.println("两个集合的并集是：");
            sets.forEach(System.out::println);
        }
    }
}
