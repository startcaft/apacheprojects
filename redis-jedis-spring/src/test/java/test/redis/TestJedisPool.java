package test.redis;

import com.redis.spring.Application;
import com.redis.spring.entityBean.UserInfo;
import com.redis.spring.util.SerializingUtil;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;

//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class TestJedisPool {

    private Jedis jedis;

    @Autowired
    private JedisPool jedisPool;

    @Before
    public void init(){
        jedis = jedisPool.getResource();
        System.out.println("清空数据当前数据库(默认数据库下标为[0])："+jedis.flushDB());
    }

    @After
    public void close(){
        jedis.close();
    }

    @Test
    public void test(){
        {
            UserInfo actual = new UserInfo();
            actual.setAge(20);
            actual.setUsername("张三");

            String key = "user.name." + actual.getUsername();
            try {
                //序列化
                jedis.set(key.getBytes(), SerializingUtil.serialize(actual));
                //反序列化
                UserInfo expected = (UserInfo) SerializingUtil.deserialize(jedis.get(key.getBytes()));

                Assert.assertEquals(expected,actual);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
