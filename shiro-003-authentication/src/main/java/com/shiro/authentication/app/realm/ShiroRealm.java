package com.shiro.authentication.app.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.ByteSource;

/**
 * Created by startcaft on 2017/4/27.
 * 自定义Realm，实现org.apache.shiro.realm接口
 */
public class ShiroRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        {
            UsernamePasswordToken upToken = (UsernamePasswordToken) token;
            String username = upToken.getUsername();
            System.out.println("从数据库中检索 username：" + username + " 所对应的用户信息.");
            if ("unkonw".equals(username)){
                throw new UnknownAccountException("用户不存在!");
            }
            if ("monster".equals(username)){
                throw new LockedAccountException("用户被锁定!");
            }

            Object principal = username;
            //"123456"用MD5加密1024次的结果
            Object credentials = null;// "fc1709d0a95a6be30bc5926fdb7f22f4";
            if ("startcaft".equals(username)){
                credentials = "71a01472435e125778614ee91ba8b74f";//加盐后的加密字符串
            }
            String realmName = getName();
            //盐值，传递给AuthenticationInfo对象
            ByteSource crendentialsSalt = ByteSource.Util.bytes(username);
            SimpleAuthenticationInfo info;
            info = new SimpleAuthenticationInfo(principal,credentials,crendentialsSalt,realmName);
            //= new SimpleAuthenticationInfo(principal,credentials,realmName);
            return info;
        }
    }

    /*
        MD5加密测试，几个重要参数：加密算法名称，循环加密次数，盐值。
     */
    public static void main(String[] agrs){
        String hashAlgorirhmName = "MD5";
        Object crendentials = "123456";
        Object salt = ByteSource.Util.bytes("startcaft");
        int hashIterations = 1024;

        Object result = new SimpleHash(hashAlgorirhmName,crendentials,salt,hashIterations);
        System.out.println(result);
    }
}
