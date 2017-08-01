package test.redis;

import com.redis.spring.Application;
import com.redis.spring.entityBean.UserInfo;
import com.redis.spring.redisStorage.UserStorage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文。
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class)
public class TestSDR {

    @Autowired
    private UserStorage userStorage;

    @Test
    public void test(){
        {
            UserInfo actual = new UserInfo();
            actual.setAge(20);
            actual.setUsername("张三");

            userStorage.addOrUpdate(actual);
            UserInfo expected = userStorage.load("张三");

            Assert.assertEquals(expected,actual);
        }
    }
}
