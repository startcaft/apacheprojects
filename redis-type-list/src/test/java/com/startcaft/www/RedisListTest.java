package com.startcaft.www;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Redis List列表常用操
 */
public class RedisListTest {

    private Jedis jedis;

    private static final String LIST_KEY = "list-key";

    @Before
    public void init(){
        jedis = JedisUtils.getInstance().getJedis(JedisUtils.ipAddr,JedisUtils.port);
        System.out.println("清空数据当前数据库(默认数据库下标为[0])："+jedis.flushDB());
    }

    @After
    public void close(){
        JedisUtils.getInstance().closeJedis(jedis,JedisUtils.ipAddr,JedisUtils.port);
    }


    @Test
    public void popAndPushTest(){

        //压入元素，返回列表的总长度
        Long result = jedis.rpush(LIST_KEY,"last");
        System.out.println("向右端压入元素，返回列表的元素总数:" + result);
        result = jedis.lpush(LIST_KEY,"first");
        System.out.println("向左端压入元素，返回列表的元素总数:" + result);
        result = jedis.rpush(LIST_KEY,"new last");
        System.out.println("向右端压入元素，返回列表的元素总数:" + result);


        //获取指定范围的元素列表
        List<String> list = jedis.lrange(LIST_KEY,0,-1);
        System.out.println("获取范围内元素，0开始，-1结束");
        list.forEach(System.out::println);


        //弹出元素，会删除元素，并返回给用户
        String str = jedis.lpop(LIST_KEY);
        System.out.println("从左边弹出元素，也就是开头，值为:" + str);//first
        str = jedis.lpop(LIST_KEY);
        System.out.println("再次从左边弹出元素，值为:" + str);//last
        list = jedis.lrange(LIST_KEY,0,-1);
        System.out.println("获取范围内元素，0开始，-1结束");
        list.forEach(System.out::println);//只有一个值了


        //同时可以压入多个值
        result = jedis.rpush(LIST_KEY,"a","b","c");
        System.out.println("向右端压入元素，返回列表的元素总数:" + result);
        list = jedis.lrange(LIST_KEY,0,-1);
        System.out.println("获取范围内元素，0开始，-1结束");
        list.forEach(System.out::println);


        //修剪列表
        String resultStr = jedis.ltrim(LIST_KEY,1,-1);
        System.out.println("从1的位置开始修剪列表，直到末尾，返回结果：" + resultStr);
        list = jedis.lrange(LIST_KEY,0,-1);//去掉new last
        System.out.println("修剪后的元素集合如下:");
        list.forEach(System.out::println);//a b c
    }


    @Test
    public void listElementMoveTest(){

        jedis.lpush(LIST_KEY,"item1");
        jedis.lpush(LIST_KEY,"item2");

        jedis.rpush(LIST_KEY + "1","item3");

        String result = jedis.brpoplpush(LIST_KEY + "1",LIST_KEY,1);
        System.out.println("列表的brpoplpush操作返回的是源列表中弹出的那个元素：" + result);
        System.out.println("将[list-key1]中的最右端的元素弹出，并压入到[list-key]的最左端");
        List<String> list = jedis.lrange(LIST_KEY,0,-1);// item3,item2,item1
        list.forEach(System.out::println);
    }
}
