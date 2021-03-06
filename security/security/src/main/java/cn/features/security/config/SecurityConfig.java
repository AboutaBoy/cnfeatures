package cn.features.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security 配置
 *
 * @author limouren
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 登录接口不需要授权
    private static final String LOGIN_ENTRY = "/api/login/**";

    // 系统 API 相关的 URI 入口
    private static final String SYSTEM_API_ENTRY = "/api/v1/**";

    // 授权方面，不拦截 swagger-ui 相关的 uri
    private static final String[] NON_TOKEN_SWAGGER_ENTRY = new String[] {
            "/webjars/**", "/swagger-resources/**", "/v2/**"
    };

    private static final String[] NON_TOKEN_STATIC_ENTRY = new String[] {
            "/static/**", "/**/*.js", "/**/*.css", "/**/*.html", "/**/*.html", "/favicon.ico"
    };

    @Autowired
    protected UserDetailsService userDetailsService;


    /**
     * 使用 Spring Security 包中的 <a href="https://en.wikipedia.org/wiki/Bcrypt">Bycrpt</a> 工具
     * 编码密码. 在其他类中，可以通过 自动注入的方式，使用 PasswordEncoder.登录时密码需要加密
     * @return 密码编码器
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    /**
     * 通过数据库
     *
     * @param managerBuilder
     */
    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 重写configure来配置那些URL需要授权,
     * 那些不需要.
     * <a>1</a>
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().cacheControl().disable().frameOptions().disable()
                .and().cors()
                .and().csrf()
                .and().authorizeRequests()
                .antMatchers(LOGIN_ENTRY).permitAll()
                .antMatchers(NON_TOKEN_SWAGGER_ENTRY).permitAll()
                .antMatchers(NON_TOKEN_STATIC_ENTRY).permitAll()
                .antMatchers(SYSTEM_API_ENTRY).authenticated()
                .anyRequest().authenticated();
    }


    public UserDetailsService getUserDetailsService() {
        return userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
