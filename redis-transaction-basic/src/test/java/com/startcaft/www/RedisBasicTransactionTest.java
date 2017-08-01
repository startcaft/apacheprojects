package com.startcaft.www;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Redis事务相关的命令有五个：WATCH，MULTI，EXEC，UNWATCH，DISCARD。
 * 这里只介绍基本的事务，相关的命令只有WATCH和EXEC。更高级的后面介绍<br/>
 *
 * 以及设置键的过期时间
 */
public class RedisBasicTransactionTest {

    private Jedis jedis;

    private static final String NO_TRANSACTION_KEY = "notrans";
    private static final String TRANSACTION_KEY = "withtrans";
    private static final String EXPIRE_KEY = "expire-key";

    @Before
    public void initJedis() {
        jedis = JedisUtils.getInstance().getJedis(JedisUtils.ipAddr, JedisUtils.port);
        System.out.println("清空数据当前数据库(默认数据库下标为[0])："+jedis.flushDB());
    }

    @After
    public void closeJedis() {
        JedisUtils.getInstance().closeJedis(jedis, JedisUtils.ipAddr, JedisUtils.port);
    }

    @Test
    public void testNoTransaction() {
        {
            //测试没有事务的时候并行执行命令，会引发的问题
            ExecutorService service = Executors.newFixedThreadPool(3);
            for(int i=0;i<10;i++){
                run(service);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            service.shutdown();
        }
    }
    private void run(ExecutorService threadPool){
        threadPool.execute(() -> {
            System.out.println(jedis.incr(NO_TRANSACTION_KEY));//自增
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(jedis.incrBy(NO_TRANSACTION_KEY,-1));//自减
        });
    }

    @Test
    public void testWithTransaction() {
        {
            ExecutorService service = Executors.newFixedThreadPool(3);
            for(int i=0;i<10;i++){
                runTrans(service);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            service.shutdown();
        }
    }
    private void runTrans(ExecutorService threadPool){
        threadPool.execute(() -> {
            //把自增操作放入事务队列Transaction
            Transaction t = jedis.multi();
            t.incr(TRANSACTION_KEY);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //把自减操作也放入事务队列Transaction
            t.incrBy(TRANSACTION_KEY,-1);
            //执行事务
            List<Object> result = t.exec();
            if (result == null || result.isEmpty()) {
                System. err.println( "Transaction error...");
                return ;
            }
            //所有包裹命令的返回消息的输出
            for (Object rt : result) {
                System. out.println(rt.toString());
            }
        });
    }


    @Test
    public void testExpire(){
        {
            jedis.set(EXPIRE_KEY,"value");
            System.out.println("设置expire-key的值为:value");

            String val = jedis.get(EXPIRE_KEY);
            System.out.println("获取expire-key的值为:" + val);

            jedis.expire(EXPIRE_KEY,3);
            System.out.println("设置expire-key键3秒后过期");

            try {
                Thread.sleep(5000);
                Long seconds = jedis.ttl(EXPIRE_KEY);
                System.out.println("查看expire-key距离过期还有多少秒：" + seconds);
                System.out.println("等待5秒之后");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            val = jedis.get(EXPIRE_KEY);
            System.out.println("在获取expire-key的值为:" + val);
        }
    }


    ///////////////正常执行事务，全体代表有错误的命令，冤头债主代表逻辑错误///////////////////
    @Test
    public void normalTransaction(){
        {
            Transaction transaction = jedis.multi();

            //命令入队
            transaction.set("k1","v1");
            transaction.set("k2","v2");

            transaction.exec();//执行
        }
    }

    ///////////////discard事务，相当于回滚事务///////////////////
    @Test
    public void discardTransaction(){
        {
            Transaction transaction = jedis.multi();

            //命令入队
            transaction.set("k3","v3");
            transaction.set("k4","v4");

            //如果出现问题
            //...

            transaction.discard();//回滚事务
        }
    }

    ///////////////check and set，redis中的乐观锁///////////////////
    @Test
    public void casTest(){
        {
            jedis.set("balance","100");
            int balance;//可用余额
            jedis.set("debt","0");
            int debt;//欠额
            int amtTosubtract = 10;//消费金额

            jedis.watch("balance");
            //jedis.set("balance","5");//此句用于模仿其他客户端对key的修改
            balance = Integer.parseInt(jedis.get("balance"));
            if (balance < amtTosubtract){
                jedis.unwatch();//取消对key的监控。
                System.out.println("modify");
            }
            else {
                System.out.println("********************transaction");
                Transaction tran = jedis.multi();
                tran.decrBy("balance",amtTosubtract);
                tran.incrBy("debt",amtTosubtract);
                tran.exec();

                balance = Integer.parseInt(jedis.get("balance"));
                debt = Integer.parseInt(jedis.get("debt"));
                System.out.println("********************" + balance);
                System.out.println("********************" + debt);
            }
        }
    }
}