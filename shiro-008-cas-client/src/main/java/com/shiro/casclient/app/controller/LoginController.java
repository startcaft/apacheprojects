package com.shiro.casclient.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String list() {
        return "list";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String loginForm(Model model){
        model.addAttribute("user", "admin");
        return "redirect:" + ShiroConfig.loginUrl;
    }
}
