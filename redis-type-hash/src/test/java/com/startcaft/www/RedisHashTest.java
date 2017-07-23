package com.startcaft.www;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisHashTest {

    private Jedis jedis;

    private static final String HASH_KEY = "hash-key";

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
    public void test1(){
        {
            Map<String,String> map = new HashMap<>();
            map.put("k1","v1");
            map.put("k2","v2");
            map.put("k3","v3");

            String result = jedis.hmset(HASH_KEY,map);
            System.out.println("往HASH散列里面添加键值对，返回的结果是：" + result);

            List<String> list = jedis.hmget(HASH_KEY,"k2","k3");
            System.out.println("hmget获取一个或多个键的值的集合");
            list.forEach(System.out::println);

            Long len = jedis.hlen(HASH_KEY);
            System.out.println("hlen获取HASH散列的键值对的总数：" + len);

            len = jedis.hdel(HASH_KEY,"K1","K3");
            System.out.println("HDEL删除一个或多个键值对，返回1则删除存在的键值对成功，返回0则可能是键值对不存在，没有进行任何操作:" + len);
        }
    }

    @Test
    public void test2(){
        {
            Map<String,String> map = new HashMap<>();
            map.put("short","hello");
            map.put("long", new String("1000"));

            String result = jedis.hmset(HASH_KEY + "2",map);
            System.out.println("往HASH散列里面添加键值对，返回的结果是：" + result);

            Set<String> keys = jedis.hkeys(HASH_KEY + "2");
            System.out.println("获取所有的key：");
            keys.forEach(System.out::println);

            //查询是否包含指定的键
            boolean flag = jedis.hexists(HASH_KEY + "2","num");
            System.out.println("指定的num键在Hash中是否存在：" + flag);

            //对不存在的键进行值的自增，会从0开始，并且该键会保存在Hash中
            long val = jedis.hincrBy(HASH_KEY + "2","num",10);
            System.out.println("对不存在Hash中的num键的值进行自增，从0开始，否则从实际值开始，结果为:" + val + "，并且num键就保存在Hash中了");

            flag = jedis.hexists(HASH_KEY + "2","num");
            System.out.println("指定的num键在Hash中是否存在：" + flag);
        }
    }
}
