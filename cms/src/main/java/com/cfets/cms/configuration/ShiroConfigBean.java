package com.cfets.cms.configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.cfets.cms.realms.MyShiroRealm;
import com.cfets.cms.realms.RetryLimitCredentialsMatcher;
import com.cfets.cms.realms.ShiroLogoutFilter;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置Bean
 */
@Configuration
public class ShiroConfigBean {

    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置login URL
        shiroFilterFactoryBean.setLoginUrl("/loginShiro");

        //配置自定义登出 覆盖 logout 之前默认的LogoutFilter
        LinkedHashMap<String, Filter> filtersMap = new LinkedHashMap<>();
        filtersMap.put("logout", shiroLogoutFilter());
        shiroFilterFactoryBean.setFilters(filtersMap);

        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 静态资源生效
        filterChainDefinitionMap.put("/thirdparty/**", "anon");
        // 设置登录的URL为匿名访问，因为一开始没有用户验证
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/loginShiro", "anon");
        //不拦截秒杀模块，用于测试秒杀性能
       // filterChainDefinitionMap.put("/seckill/**", "anon");
        // 退出系统的过滤器
        filterChainDefinitionMap.put("/logout", "logout");
        // 最后一班都，固定格式
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


    /*
     * 凭证匹配器
     */
    @Bean
    public RetryLimitCredentialsMatcher hashedCredentialsMatcher() {
        RetryLimitCredentialsMatcher hashedCredentialsMatcher = new RetryLimitCredentialsMatcher(ehCacheManager());
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(2);// 散列的次数
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);//转化为16进制(与入库时保持一致)
        return hashedCredentialsMatcher;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());//配置shiro密码验证参数
        return myShiroRealm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入自定义的realm;
        securityManager.setRealm(myShiroRealm());
        // 注入缓存管理器;
        securityManager.setCacheManager(ehCacheManager());

        return securityManager;
    }

    /*
     * 开启shiro aop注解支持 使用代理方式;所以需要开启代码支持;
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /*
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中-->安全管理器：securityManager可见securityManager是整个shiro的核心；
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        System.out.println("ShiroConfiguration.getEhCacheManager()");
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return cacheManager;
    }

    /**
     * 配置ShiroDialect,用于thymeleaf和shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }


    /**
     * 配置LogoutFilter
     *
     * @return
     */
    public ShiroLogoutFilter shiroLogoutFilter() {
        ShiroLogoutFilter shiroLogoutFilter = new ShiroLogoutFilter();
        //配置登出后重定向的地址，等出后配置跳转到登录接口
        shiroLogoutFilter.setRedirectUrl("/login");
        return shiroLogoutFilter;
    }

}
