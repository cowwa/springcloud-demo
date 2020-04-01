package com.example.serveroauth.config;

import com.example.serveroauth.model.Permission;
import com.example.serveroauth.model.Role;
import com.example.serveroauth.repository.PermissionRepository;
import com.example.serveroauth.repository.RoleRepository;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：MyInvocationSecurityMetadataSourceService
 * 类 描 述：验证请求与资源的关系
 * FilterInvocationSecurityMetadataSource 的作用是用来储存请求与权限的对应关系。
 * 创建时间：2020/3/18 14:34
 *
 * @author：cowwa
 */
@Component
@Slf4j
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    PermissionRepository permissionRepository;


    /**
     * 记录每个资源所需要的角色
     */
    private static Map<String,Collection<ConfigAttribute>> map=null;

    /**
     * 当接收到一个http请求时, filterSecurityInterceptor会调用的方法.
     * 参数object是一个包含url信息的HttpServletRequest实例.
     * 这个方法要返回请求该url所需要的所有权限集合。
     * 也就就是返回该请求所需要的资源角色
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        initPermissionMap();
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        for (Iterator<String> it = map.keySet().iterator() ; it.hasNext();) {
            String url = it.next();
            if (new AntPathRequestMatcher( url ).matches( request )) {
                return map.get( url );
            }
        }
        return null;
    }

    /**
     * Spring容器启动时自动调用, 一般把所有请求与权限的对应关系也要在这个方法里初始化, 保存在一个属性变量里
     * @return
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     * 指示该类是否能够为指定的方法调用或Web请求提供ConfigAttributes
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    private void initPermissionMap(){
        if(Objects.isNull(map)){
            map= new HashMap<>(16);
            List<Permission> permissionList= permissionRepository.findAll();
            permissionList.forEach(permission -> {
                Set<ConfigAttribute> configAttributeSet=new HashSet<>();
                permission.getRoleSet().forEach(role -> {
                    configAttributeSet.add(new SecurityConfig(role.getName()));
                });
                if(map.containsKey(permission.getUrl())){
                    map.get(permission.getUrl()).addAll(configAttributeSet);
                }else {
                    map.put(permission.getUrl(),configAttributeSet);
                }
            });
        }
    }
}
