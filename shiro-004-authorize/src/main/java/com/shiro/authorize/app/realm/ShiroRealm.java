package com.shiro.authorize.app.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by startcaft on 2017/4/27.
 * 自定义Realm，实现org.apache.shiro.realm接口
 */
public class ShiroRealm extends AuthorizingRealm {

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

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //System.out.println("authorization");

        //1，用 PrincipalCollection 中来获取登录用户的信息
        Object prinicipal = principals.getPrimaryPrincipal();//多Realm获取Principal的顺序跟认证时设置的Realm的顺序的一样。

        //2，利用登陆用户的信息来为登陆用户授权，一般是通过查询数据库
        Set<String> roles = new HashSet<>();
        if (prinicipal.equals("startcaft")){
            roles.add("admin");
        }
        //3，创建 SimpleAuthorizationInfo 并设置其 roles 属性
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        return info;
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
