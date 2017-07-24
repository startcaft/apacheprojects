package com.startcaft.www;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.ZParams;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RedisZsetTest {

    private Jedis jedis;

    private static final String ZSET_KEY = "zset-key";

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
            Map<String,Double> map = new HashMap<>();
            map.put("a",new Double(3));
            map.put("b",new Double(2));
            map.put("c",new Double(1));

            Long result = jedis.zadd(ZSET_KEY,map);
            System.out.println("ZADD向有序集合添加元素，返回1则表示新插入的元素，返回0则表示插入的元素已存在，会更新已存在的元素，一次性插入一个Map，则返回插入/更新元素的总数。" + result);

            result = jedis.zcard(ZSET_KEY);
            System.out.println("ZCARD获取有序集合的元素总数：" + result);

            Double newScore = jedis.zincrby(ZSET_KEY,new Double(5),"c");
            System.out.println("ZINCRBY给指定成员增加指定的分值，返回新的分值：" + newScore);//1 + 5 = 6

            //范围获取成员，附带分值一起返回，Tuple对象包装了成员和分值
            Set<Tuple> tuples = jedis.zrangeWithScores(ZSET_KEY, 0, -1);
            System.out.println("ZREANGE WithScores范围获取所有成员，附带分值一起返回");
            tuples.forEach((t) -> {
                System.out.println("成员：" + t.getElement() + "---分值：" + t.getScore());
            });

            //获取单个成员的分值
            newScore = jedis.zscore(ZSET_KEY,"c");
            System.out.println("有序集合中成员c的分值为：" + newScore);//6.0

            //获取单个成员的排名
            result = jedis.zrank(ZSET_KEY,"a");
            System.out.println("有序集合中成员a的排行：" + result);

            //移除一个或多个成员
            result = jedis.zrem(ZSET_KEY,"c");
            System.out.println("zrem从有序集合中移除成员，返回的是移除的数量：" + result);
        }
    }


    @Test
    public void test2(){
        {
            //初始化两个有序集合，b，c 重复
            Map<String,Double> map = new HashMap<>();
            map.put("a",new Double(1));
            map.put("b",new Double(2));
            map.put("c",new Double(3));
            jedis.zadd(ZSET_KEY,map);

            map = new HashMap<>();
            map.put("b",new Double(4));
            map.put("c",new Double(1));
            map.put("d",new Double(0));
            jedis.zadd(ZSET_KEY + "1",map);


            //ZINTERSTORE和ZUNIONSTORE默认会使用聚合函数'sum'，该函数会把各个有序集合的成员的分值加起来。
            System.out.println("类似交集");
            jedis.zinterstore(ZSET_KEY + "i",ZSET_KEY,ZSET_KEY + "1");//交集
            Set<Tuple> tuples = jedis.zrangeWithScores(ZSET_KEY + "i", 0, -1);
            tuples.forEach((t) -> {
                System.out.println("成员：" + t.getElement() + "------分值：" + t.getScore());
            });

            //使用指定聚合函数'min'
            System.out.println("类似并集");
            ZParams params = new ZParams().aggregate(ZParams.Aggregate.MIN);
            jedis.zunionstore(ZSET_KEY + "u",params,ZSET_KEY,ZSET_KEY + "1");
            tuples = jedis.zrangeWithScores(ZSET_KEY + "u", 0, -1);
            tuples.forEach((t) -> {
                System.out.println("成员：" + t.getElement() + "------分值：" + t.getScore());
            });
        }
    }
}


