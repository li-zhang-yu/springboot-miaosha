package com.github.springbootmiaosha.config;

import com.github.springbootmiaosha.security.AuthProvider;
import com.github.springbootmiaosha.security.LoginAuthFailHandler;
import com.github.springbootmiaosha.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 权限配置类
 *
 * @author lizhangyu
 * @Date 2019-08-09
 */
@EnableWebSecurity
//@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 管理员登录入口
                .antMatchers("/admin/login").permitAll()
                // 静态资源
                .antMatchers("/static/**").permitAll()
                // 用户登录入口
                .antMatchers("/user/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                // 配置角色登录处理入口
                .loginProcessingUrl("/login")
                .failureHandler(authFailHandler())
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/logout/page")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(urlEntryPoint())
                .accessDeniedPage("/403");

        //关闭默认的csrf认证
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    /**
     * 自定义认证策略
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception{
        //可以设置内存指定的登录的账号密码,指定角色
        //不加.passwordEncoder(new MyPasswordEncoder())
        //就不是以明文的方式进行匹配，会报错
//        auth.inMemoryAuthentication().withUser("admin").password("admin")
//                .roles("ADMIN").and();
//        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("admin")
//                .roles("ADMIN").and();
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }

    @Bean
    public AuthProvider authProvider(){
        return new AuthProvider();
    }

    @Bean
    public LoginUrlEntryPoint urlEntryPoint(){
        return new LoginUrlEntryPoint("/user/login");
    }

    @Bean
    public LoginAuthFailHandler authFailHandler(){
        return new LoginAuthFailHandler(urlEntryPoint());
    }

}
