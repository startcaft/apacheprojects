package com.startcaft.www;

import redis.clients.jedis.Jedis;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Jedis jedis = JedisUtils.getInstance().getJedis(JedisUtils.ipAddr, JedisUtils.port);
        System.out.println("清空数据当前数据库(默认数据库下标为[0])："+jedis.flushDB());


        RedisDao dao = new RedisDao();
        //发布文章
        dao.post_article("1","百度就是个流氓公司1","http://www.baidu.com");
        dao.post_article("2","百度就是个流氓公司2","http://www.baidu.com");
        dao.post_article("3","百度就是个流氓公司3","http://www.baidu.com");
        dao.post_article("3","百度就是个流氓公司33","http://www.baidu.com");
        dao.post_article("2","百度就是个流氓公司22","http://www.baidu.com");
        dao.post_article("1","百度就是个流氓公司11","http://www.baidu.com");
        dao.post_article("1","百度就是个流氓公司111","http://www.baidu.com");

        //对文章进行投票
        dao.article_vote("5","1");
        dao.article_vote("6","1");
        dao.article_vote("7","1");
        dao.article_vote("8","1");
        dao.article_vote("9","1");
        dao.article_vote("5","2");


        LinkedList<Map<String, String>> articles = dao.get_articles(1);
        articles.forEach((m) -> {
            System.out.println(m);
        });
    }
}
