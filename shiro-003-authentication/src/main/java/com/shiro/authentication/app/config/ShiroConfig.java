package com.shiro.authentication.app.config;

import com.shiro.authentication.app.realm.SecondRealm;
import com.shiro.authentication.app.realm.ShiroRealm;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AllSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by startcaft on 2017/4/27.
 */
/*Shiro集成配置类*/
@Configuration
public class ShiroConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);

    /*配置EhCacheManager,shiro会缓存用户权限和角色信息*/
    @Bean
    public EhCacheManager cacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return cacheManager;
    }

    /*配置LifecycleBeanPostProcessor声明周期管理器，它可以自动地来调用配置在IOC容器中的 shiro bean 的生命周期方法，这个bean不能少*/
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /*配置自定义Realm，也就是安全数据的来源，MD5加密*/
    @Bean
    public ShiroRealm shiroRealm() {

        ShiroRealm realm = new ShiroRealm();
        HashedCredentialsMatcher md5 = new HashedCredentialsMatcher();
        md5.setHashAlgorithmName("MD5");
        md5.setHashIterations(1024);
        realm.setCredentialsMatcher(md5);
        return realm;
    }

    /*配置自定义Realm，组成多Realm认证，SHA1加密*/
    @Bean
    public SecondRealm secondRealm(){
        SecondRealm secondRealm = new SecondRealm();
        HashedCredentialsMatcher sha1 = new HashedCredentialsMatcher();
        sha1.setHashAlgorithmName("SHA1");
        sha1.setHashIterations(1024);
        secondRealm.setCredentialsMatcher(sha1);
        return secondRealm;
    }

    /*配置认证器，如果有需要可以改变一下默认的认证策略*/
    @Bean
    public Authenticator authenticator(@Autowired ShiroRealm shiroRealm,
                                       @Autowired SecondRealm secondRealm){
        ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();

        List<Realm> mulRealms = new LinkedList<>();
        mulRealms.add(shiroRealm);
        mulRealms.add(secondRealm);
        authenticator.setRealms(mulRealms);
        authenticator.setAuthenticationStrategy(new AllSuccessfulStrategy());//每个Realm认证成功才算验证通过

        return  authenticator;
    }


    @Bean
    public RememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();

        //构建一个Cookie实例，默认实现SimpleCookie
        Cookie cookie = new SimpleCookie();
        cookie.setMaxAge(10);//10秒
        cookie.setName("remeberMe");//cookie name

        cookieRememberMeManager.setCookie(cookie);
        return cookieRememberMeManager;
    }

    /*配置核心安全管理器SecurityManager，依赖于Realm或者认证器(多Realm认证)，必须从中读取安全数据*/
    @Bean
    public SecurityManager securityManager(@Autowired Authenticator authenticator,
                                           @Autowired EhCacheManager cacheManager,
                                           @Autowired RememberMeManager rememberMeManager) {

        LOGGER.info("shior------init");

        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //manager.setRealm(shiroRealm);
        manager.setAuthenticator(authenticator);//注入认证器
        manager.setCacheManager(cacheManager);
        manager.setRememberMeManager(rememberMeManager);//设置rememberMeManager

        return manager;
    }

    /*启用 IOC 容器中使用 shiro 的注解，但是必须在配置了  lifecycleBeanPostProcessor 才可以使用*/
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Autowired SecurityManager manager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }

    /*该bean的名称必须为shiroFilter*/
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(manager);

        //配置登录需要跳转的url和登录成功后跳转的url以及认证失败后跳转的url
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/list");
        bean.setUnauthorizedUrl("/unauthorized");

        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login", "anon"); //表示可以匿名访问
        filterChainDefinitionMap.put("/logout","logout");//登出

        filterChainDefinitionMap.put("/list","user");//通过记住我登录也可以进行访问
        //filterChainDefinitionMap.put("/admin","authc,roles[user]");//认证，还要拥有user权限

        filterChainDefinitionMap.put("/**", "authc");//标识需要认证才能访问
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    /*最后配置一个shiroFilter 拦截器，拦截所有的url请求，该filter-name的配置必须跟Spring容器中配置的bean的id一致*/
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
    }

}
