package com.shiro.casclient.app.config;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.cas.CasFilter;
import org.apache.shiro.cas.CasSubjectFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;
import com.shiro.casclient.app.realm.MyCasRealm;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;

/**
 * Created by startcaft on 2017/4/27.
 */
@SuppressWarnings("deprecation")
/* Shiro集成配置类 */
@Configuration
public class ShiroConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);

	// CasServerUrlPrefix
	public static final String casServerUrlPrefix = "http://192.168.1.2:8080/cas";
	// Cas登录页面地址
	public static final String casLoginUrl = casServerUrlPrefix + "/login";
	// Cas登出页面地址
	public static final String casLogoutUrl = casServerUrlPrefix + "/logout";
	// 当前工程对外提供的服务地址
	public static final String shiroServerUrlPrefix = "http://localhost:8080/shiro-008-cas-client";
	// casFilter UrlPattern
	public static final String casFilterUrlPattern = "/shiro-cas";
	// 登录地址
	public static final String loginUrl = casLoginUrl + "?service=" + shiroServerUrlPrefix + casFilterUrlPattern;

	@Bean
	public EhCacheManager cacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
		return cacheManager;
	}

	@Bean
	public MyCasRealm casRealm() {
		MyCasRealm realm = new MyCasRealm();
		//配置CAS Server服务器端地址
		realm.setCasServerUrlPrefix(ShiroConfig.casServerUrlPrefix);
		//是当前应用CAS服务URL，即用于接收并处理登录成功后的Ticket的
		realm.setCasService(shiroServerUrlPrefix + casFilterUrlPattern);
		return realm;
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new DelegatingFilterProxy("shiroFilter"));
		filterRegistration.setEnabled(true);
		filterRegistration.addUrlPatterns("/*");
		filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
		return filterRegistration;
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

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
	
	/****************************************************************************************************************************/
	
	@Bean
	public SecurityManager securityManager(@Autowired EhCacheManager cacheManager,
									@Autowired MyCasRealm casRealm) {
		LOGGER.info("shior------init");
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(casRealm);
		manager.setCacheManager(cacheManager);
		manager.setSubjectFactory(new CasSubjectFactory());
		return manager;
	}

	/*
     * CasFilter类似于FormAuthenticationFilter，只不过其验证服务器端返回的CAS Service Ticket
     */
    @Bean(name = "casFilter")
    public CasFilter getCasFilter() {
        CasFilter casFilter = new CasFilter();
        // 登录失败后跳转的URL，也就是 Shiro 执行 CasRealm 的 doGetAuthenticationInfo 方法向CasServer验证tiket
        casFilter.setFailureUrl("/unauthorized");//认证失败后的跳转页面
        return casFilter;
    }

	/* 该bean的名称必须为shiroFilter */
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Autowired SecurityManager securityManager, 
														@Autowired CasFilter casFilter) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager  
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        // 登录成功后要跳转的连接
        shiroFilterFactoryBean.setSuccessUrl("/list");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        // 添加casFilter到shiroFilter中
        Map<String, Filter> filters = new HashMap<>();
        filters.put("casFilter", casFilter);
        shiroFilterFactoryBean.setFilters(filters);

        loadShiroFilterChain(shiroFilterFactoryBean);
        return shiroFilterFactoryBean;
    }
	
	/**
     * 加载shiroFilter权限控制规则（从数据库读取然后配置）
     */
    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean){
    	
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        filterChainDefinitionMap.put(casFilterUrlPattern, "casFilter");// shiro集成cas后，首先添加该规则

        filterChainDefinitionMap.put("/list", "authc");// 这里为了测试，只限制/list，实际开发中请修改为具体拦截的请求规则
        filterChainDefinitionMap.put("/**", "anon");//anon 可以理解为不拦截
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    }
}
