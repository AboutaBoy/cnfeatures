package cn.features.shiro.config;

import com.google.common.collect.Maps;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Map;


/**
 * shiro配置
 * http://shiro.apache.org/spring-boot.html
 */
@Configuration
public class MyShiroConfig {


    @Bean
    public MyRealmConfig realm() {
        MyRealmConfig myRealmConfig = new MyRealmConfig();
        return myRealmConfig;
    }

    /**
     * 配置restfulAPI是否需要用户登录
     *
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {

        Map<String, String> map = Maps.newHashMap();
        map.put("/webjars/**", "unauth");
        map.put("/swagger-resources/**", "unauth");
        map.put("/v2/**", "unauth");
        map.put("/static/**", "unauth");
        map.put("/**/*.js", "unauth");
        map.put("/**/*.css", "unauth");
        map.put("/**/*.html", "unauth");
        map.put("/favicon.ico", "unauth");
        map.put("/favicon.ico", "unauth");

        ShiroFilterFactoryBean chainDefinition = new ShiroFilterFactoryBean();
        chainDefinition.setSecurityManager(defaultWebSecurityManager());
        chainDefinition.setFilterChainDefinitionMap(map);
        Map<String, Filter> filterMap = Maps.newHashMap();
        filterMap.put("anon", new AnonymousFilter());
        filterMap.put("authc", new FormAuthenticationFilter());
        filterMap.put("logout", new LogoutFilter());
        filterMap.put("roles", new RolesAuthorizationFilter());
        filterMap.put("user", new UserFilter());
        chainDefinition.setFilters(filterMap);
        return chainDefinition;
    }


    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(myRealmConfig());
        return defaultWebSecurityManager;
    }

    @Bean
    public MyRealmConfig myRealmConfig() {
        MyRealmConfig myRealmConfig = new MyRealmConfig();
        return myRealmConfig;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}
