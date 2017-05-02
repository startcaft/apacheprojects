package com.shiro.authorize.app.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by startcaft on 2017/4/28.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            /**把用户名或密码封装成 UsernamePassworkToken 对象**/
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            /**记住我，remeberme**/
            token.setRememberMe(true);
            try {
                /**执行登录**/
                subject.login(token);
            } catch (AuthenticationException ae) {
                System.out.println("登录失败:" + ae.getMessage());
            }
        }

        return "redirect:/list";
    }


    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "list";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(){return "user";}

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(){return "admin";}
}
