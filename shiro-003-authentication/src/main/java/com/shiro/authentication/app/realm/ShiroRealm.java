package com.shiro.authentication.app.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;

/**
 * Created by startcaft on 2017/4/27.
 * 自定义Realm，实现org.apache.shiro.realm接口
 */
public class ShiroRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        {
            //1，把 AuthenticationToken 转换为 UserNamePasswordToken
            UsernamePasswordToken upToken = (UsernamePasswordToken) token;

            //2，从 UserNamePasswordToken 中获取username
            String username = upToken.getUsername();

            //3，调用数据库的方法，从数据库中检索 username 对应的用户记录
            System.out.println("从数据库中检索 username：" + username + " 所对应的用户信息.");

            //4，若用户不存在，则可以抛出 UnknownAccountException 异常
            if ("unkonw".equals(username)){
                throw new UnknownAccountException("用户不存在!");
            }

            //5，根据用户信息的情况，决定是否需要抛出其他的 AuthenticationException 异常
            if ("monster".equals(username)){
                throw new LockedAccountException("用户被锁定!");
            }

            //6，根据用户的情况，来构建 AuthenticationInfo 对象并返回。通常使用的实现类为：org.apache.shiro.authc.SimpleAuthenticationInfo
            //以下信息是从数据库中获取的
            //1).principal：认证的实体信息，可以是username，也可以是封装好的用户实体对象。
            Object principal = username;
            //2).credentials：加密数据。
            Object credentials = "123456";
            //3).realmName：当前 Realm 的name，调用父类 getName() 即可。
            String realmName = getName();
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,realmName);
            return info;
        }
    }
}
