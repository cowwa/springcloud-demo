package com.example.serveroauth.config;

import com.example.serveroauth.model.User;
import com.example.serveroauth.repository.RoleRepository;
import com.example.serveroauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.Objects;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：MyUserDetailsService
 * 类 描 述：定义自己的用户信息service,来获取该用户的所有信息
 * 创建时间：2020/3/18 11:06
 *
 * @author：cowwa
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       return userRepository.findByUsername(username);

    }
}
