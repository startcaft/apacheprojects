package com.startcaft.www;

import redis.clients.jedis.Jedis;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by startcaft on 2017/7/20.
 */
public class RedisDao {

    private Jedis jedis;

    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;//一个星期的秒数
    private static final int VOTE_SCORE = 432;//每次投票，文章进行积分
    private static final int ARTICLES_PER_PAGE = 25;

    public RedisDao() {
        jedis = JedisUtils.getInstance().getJedis(JedisUtils.ipAddr,JedisUtils.port);
    }

    public RedisDao(Jedis jedis) {
        this.jedis = jedis;
    }


    /**
     * 发布，并获取一个文章<br/>
     * @param userId 发布者ID
     * @param title 文章标题
     * @param link 文章连接地址
     */
    public void post_article(String userId,String title,String link){
        String article_id = new String(jedis.incr("article:")+"");

        //将发布用户ID记录到已投票用户名单中，防止用户对同一文章多次投票
        //并将为这个文章的已投票集合设置一个星期的过期时间
        String votedKey = "voted:" + article_id;
        jedis.sadd(votedKey,userId);
        jedis.expire(votedKey,ONE_WEEK_IN_SECONDS);

        //保存文章
        String now = System.currentTimeMillis()+"";
        String articleKey = "article:" + article_id;
        Map<String,String> articleMap = new HashMap<>();
        articleMap.put("title",title);
        articleMap.put("link",link);
        articleMap.put("poster",userId);
        articleMap.put("time",now);
        articleMap.put("votes","1");
        jedis.hmset(articleKey,articleMap);

        //保存到文件-评分有序集合
        jedis.zadd("score",new Double(now + VOTE_SCORE),articleKey);
        //保存到文章-时间有序集合
        jedis.zadd("time",new Double(now),articleKey);
    }

    /**
     * 对文章进行投票
     * @param userId 投票人id
     * @param articleId 文章id
     */
    public void article_vote(String userId,String articleId){
        int cutOff = LocalDateTime.now().getSecond() - ONE_WEEK_IN_SECONDS;
        //计算文章的投票文章截止时间
        if (jedis.zscore("time","article:" + articleId) < cutOff){
            return;
        }

        long flag = jedis.sadd("voted:" + articleId,userId);
        if (flag == 1){//新添加元素，则表示该用户第一次对指定文章投票,0则是已经投票过了。
            jedis.zincrby("score",VOTE_SCORE,"article:"+articleId);//score有序集合中的指定成员分数自增一个VOTE_SCORE
            jedis.hincrBy("article:"+articleId,"votes",1);//文章集合中的成员votes自增指定数量1
        }
    }

    /**
     * 分页获取文章列表<br/>
     * 按照评分来排序，从小到大<br/>
     * @param pageIndex
     * @return
     */
    public LinkedList<Map<String,String>> get_articles(int pageIndex){
        //设置获取文章的起始索引和结束索引
        int start = (pageIndex - 1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;

        Set<String> articleKeys = jedis.zrevrange("score",start,end);//获取多个文章ID

        LinkedList<Map<String,String>>  articles = new LinkedList<>();
        articleKeys.forEach((k) -> {
            //根据文章id获取文章的详细信息
            Map<String, String> articleMap = jedis.hgetAll(k);
            articles.add(articleMap);
        });

        return articles;
    }
}
