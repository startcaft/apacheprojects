package com.startcaft.www;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * Created by startcaft on 2017/7/21.
 */
public class RedisStringTest {

    private Jedis jedis;

    @Before
    public void init(){
        jedis = JedisUtils.getInstance().getJedis(JedisUtils.ipAddr,JedisUtils.port);
        System.out.println("清空数据当前数据库(默认数据库下标为[0])："+jedis.flushDB());
    }

    @After
    public void close(){
        JedisUtils.getInstance().closeJedis(jedis,JedisUtils.ipAddr,JedisUtils.port);
    }


    //测试redis string中提供的incr*和decr* 自增/自减操作
    @Test
    public void testIncrAndDecr(){
        {
            //获取一个不存在的键，返回的是一个Null值
            String str = jedis.get("key");
            if (str == null || str == ""){
                System.out.println("找不到键[key]所对应的值");
            }
            else{
                System.out.println("找不到键[key]=" + str);
            }

            //对一个不存在的key是可以进行自增/自减的，从0开始
            long value = jedis.incr("key");
            System.out.println("键[key]不存在，但是可以自增，从0开始自增，所以incr后=" + value);//1

            value = jedis.incrBy("key",15);
            System.out.println("键[key]不存在，但是可以自增，从0开始自增，所以incrBy后=" + value);//16

            value = jedis.decrBy("key",5);
            System.out.println("键[key]不存在，但是可以自减，从0开始自增，所以decrBy后=" + value);//11


            //成功设置一个字符串的键值对，返回ok
            String setResult = jedis.set("key","13");
            System.out.println("set字符串后的返回：" + setResult);


            value = jedis.incr("key");
            System.out.println("键[key]已经存在，且可以被redis识别为一个整数，所以可以进行自增/自减操作，自增后=" + value);//14
        }
    }

    //redis string提供的子串操作和二进制位串
    @Test
    public void subStringTest(){
        {
            //追到字符串到一个不存在的key中
            Long result = jedis.append("new-string-key","hello ");
            System.out.println("将指定字符串追加到一个暂不存在的key中，返回的是追加字符串的长度(总字符串的长度):" + result);

            result = jedis.append("new-string-key","world!");
            System.out.println("将指定字符串追加到一个已经存在的key中，返回的是总字符串的长度:" + result);

            //截取指定范围内的字符串
            String subStr = jedis.substr("new-string-key",3,7);
            System.out.println("截取指定范围内的字符串:" + subStr);

            result = jedis.setrange("new-string-key",0,"H");//返回总字符串长度
            result = jedis.setrange("new-string-key",6,"W");//返回总字符串长度
            System.out.println("更改字符串指定位置的字节的值，变更后的值为:" + jedis.get("new-string-key"));

            result = jedis.setrange("new-string-key",11,", how are you?");
            System.out.println("从字符串末尾更新，也可以当作是一个追加操作:" + jedis.get("new-string-key"));


            //二进制位串就不实验了，
        }
    }
}
