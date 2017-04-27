package com.shiro.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by startcaft on 2017/4/27.
 */
@Controller
public class ShiroController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(){
        return "list";
    }

    @RequestMapping(value = "/unauthorized",method = RequestMethod.GET)
    public String unauthorized(){
        return "unauthorized";
    }
}
