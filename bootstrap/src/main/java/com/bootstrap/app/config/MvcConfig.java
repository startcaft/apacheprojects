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

            //全局样式之代码
            registry.addViewController("/global/code").setViewName("globalstyle/code/index");
            registry.addViewController("/global/code/inline").setViewName("globalstyle/code/inline_code");
            registry.addViewController("/global/code/input").setViewName("globalstyle/code/user_input");
            registry.addViewController("/global/code/block").setViewName("globalstyle/code/code_block");
            registry.addViewController("/global/code/var").setViewName("globalstyle/code/variable");
            registry.addViewController("/global/code/print").setViewName("globalstyle/code/print");

            //全局样式之表格
            registry.addViewController("/global/table").setViewName("globalstyle/table/index");
            registry.addViewController("/global/table/base").setViewName("globalstyle/table/base");
            registry.addViewController("/global/table/strip").setViewName("globalstyle/table/strip");
            registry.addViewController("/global/table/border").setViewName("globalstyle/table/border");
            registry.addViewController("/global/table/hover").setViewName("globalstyle/table/hover");
            registry.addViewController("/global/table/condensed").setViewName("globalstyle/table/condensed");
            registry.addViewController("/global/table/state").setViewName("globalstyle/table/state");
            registry.addViewController("/global/table/responsive").setViewName("globalstyle/table/responsive");

            //全局样式之表单
            registry.addViewController("/global/form").setViewName("globalstyle/form/index");
            registry.addViewController("/global/form/base").setViewName("globalstyle/form/base");
            registry.addViewController("/global/form/inline").setViewName("globalstyle/form/inline");
            registry.addViewController("/global/form/horizontal").setViewName("globalstyle/form/horizontal");
            registry.addViewController("/global/form/support").setViewName("globalstyle/form/support");
            registry.addViewController("/global/form/static").setViewName("globalstyle/form/static");
            registry.addViewController("/global/form/focus").setViewName("globalstyle/form/focus");
            registry.addViewController("/global/form/disable").setViewName("globalstyle/form/disable");
            registry.addViewController("/global/form/readonly").setViewName("globalstyle/form/readonly");
            registry.addViewController("/global/form/help").setViewName("globalstyle/form/help");
            registry.addViewController("/global/form/state").setViewName("globalstyle/form/state");
            registry.addViewController("/global/form/size").setViewName("globalstyle/form/size");
        }
    }

    /*接受路径参数中的. ，/a/b/c.d*/
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
