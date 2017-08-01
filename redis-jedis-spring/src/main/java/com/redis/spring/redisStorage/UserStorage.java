package com.redis.spring.redisStorage;

import com.redis.spring.entityBean.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserStorage {

    @Autowired
    private RedisTemplate<String,UserInfo> redisTemplate;

    public void addOrUpdate(UserInfo userInfo){
        redisTemplate.opsForValue().set("user.name." + userInfo.getUsername(),userInfo);
    }

    public UserInfo load(String username){
        return redisTemplate.opsForValue().get("user.name." + username);
    }
}
