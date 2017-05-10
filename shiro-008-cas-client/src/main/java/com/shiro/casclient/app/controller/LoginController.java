package com.shiro.casclient.app.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shiro.casclient.app.config.ShiroConfig;

/**
 * Created by startcaft on 2017/4/28.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public String unauthorized() {
        return "unauthorized";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list() {
    	
    	Subject subject = SecurityUtils.getSubject();
    	String username = (String) subject.getPrincipal();
    	
        return "你好：" + username + "，是否包含[admin]角色：" + subject.hasRole("admin");
    }
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("user", "admin");
        return "redirect:" + ShiroConfig.loginUrl;
    }
}
