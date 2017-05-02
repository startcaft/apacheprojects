package com.shiro.authorize.app.service;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by startcaft on 2017/5/2.
 */
@Service
public class ShiroService {

    //如果注解式事物，那么shiro注解应该放在Controller层，因为两个代理对象在类型转换时会报错。
    //@RequiresRoles({"user"})
    public void testMethod(){
        System.out.println("test anon methos,time : "+ new Date());
    }
}
