package com.bootstrap.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 保留SpringBoot的MVC特性，加入自定义配置
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /*静态资源处理*/
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /*配置快捷的ViewController，只是页面跳转的Controller*/
    public void addViewControllers(ViewControllerRegistry registry) {
        {
            //网格系统
            registry.addViewController("/gridsystem/1").setViewName("gridsystem/grid");
            registry.addViewController("/gridsystem/2").setViewName("gridsystem/grid2");
            registry.addViewController("/gridsystem/3").setViewName("gridsystem/grid3");

            //容器
            registry.addViewController("/container").setViewName("container/container");

            //全局样式之排版
            registry.addViewController("/global/paiban").setViewName("globalstyle/paiban/index");
            registry.addViewController("/global/paiban/title").setViewName("globalstyle/paiban/title");
            registry.addViewController("/global/paiban/body").setViewName("globalstyle/paiban/body_and_p");
            registry.addViewController("/global/paiban/inline").setViewName("globalstyle/paiban/inline");
            registry.addViewController("/global/paiban/align").setViewName("globalstyle/paiban/align");
            registry.addViewController("/global/paiban/change").setViewName("globalstyle/paiban/changeSize");
            registry.addViewController("/global/paiban/abbr").setViewName("globalstyle/paiban/abbr");
            registry.addViewController("/global/paiban/address").setViewName("globalstyle/paiban/address");
            registry.addViewController("/global/paiban/blockquote").setViewName("globalstyle/paiban/blockquote");
            registry.addViewController("/global/paiban/list").setViewName("globalstyle/paiban/list");
        }
    }

    /*接受路径参数中的. ，/a/b/c.d*/
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
