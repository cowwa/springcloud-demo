package com.example.serveroauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：ApplicationSecurity
 * 类 描 述：系统身份认证
 * 创建时间：2020/3/13 16:59
 * 创 建 人：cowwa
 * @author cowwa
 */
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) {
        builder.jdbcAuthentication().dataSource(dataSource).withUser("dave")
                .password("secret").roles("USER");
    }

}
