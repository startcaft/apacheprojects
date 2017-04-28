package com.shiro.authentication.app.config;

import com.shiro.authentication.app.realm.ShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
import java.util.LinkedHashMap;

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

    /*配置具体的凭证匹配器，并设置其加密算法和加密次数*/
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /*配置自定义Realm，也就是安全数据的来源*/
    @Bean
    public ShiroRealm shiroRealm(@Autowired HashedCredentialsMatcher hashedCredentialsMatcher) {

        ShiroRealm realm = new ShiroRealm();
        realm.setCredentialsMatcher(hashedCredentialsMatcher);
        return realm;
    }

    /*配置核心安全管理器SecurityManager，依赖于Realm，必须从中读取安全数据*/
    @Bean
    public SecurityManager securityManager(@Autowired ShiroRealm shiroRealm,
                                           @Autowired EhCacheManager cacheManager) {

        LOGGER.info("shior------init");

        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(shiroRealm);
        manager.setCacheManager(cacheManager);
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
