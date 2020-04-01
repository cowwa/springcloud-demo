package com.example.serveroauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import javax.sql.DataSource;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：ApplicationSecurity
 * 类 描 述：系统身份认证
 * 创建时间：2020/3/13 16:59
 * 创 建 人：cowwa
 * @author cowwa
 */
@Configurable
@EnableWebSecurity
@Slf4j
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //不验证权限
                .antMatchers("/","index","/login","/login-error","/401","/css/**","/js/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage( "/login" ).failureUrl( "/login-error" )
                .and()
                .exceptionHandling().accessDeniedPage( "/401" );
        http.logout().logoutSuccessUrl( "/" );
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        //校验用户
        builder.userDetailsService(myUserDetailsService).passwordEncoder(new PasswordEncoder() {
            //密码加密
            @Override
            public String encode(CharSequence rawPassword) {
                log.debug("rawPassword:{}",rawPassword);
                return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
            }
            //解密
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                String encode = DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
                log.debug("encode:{}",encode);
                return encodedPassword.equals( encode );
            }
        });
    }

}
