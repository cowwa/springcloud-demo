package com.example.serveroauth.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：MyAccessDecisionManager
 * 类 描 述：决策器
 * AccessDecisionManager是由AbstractSecurityInterceptor调用的，它负责鉴定用户是否有访问对应资源（方法或URL）的权限
 * 创建时间：2020/3/18 15:44
 *
 * @author：cowwa
 */
@Component
@Slf4j
public class MyAccessDecisionManager implements AccessDecisionManager {

    /**
     *
     * @param authentication 当前的用户信息，包括拥有的权限。
     *                       这里的权限来源就是前面登录时UserDetailsService中设置的authorities。
     *                       获取用户相应的角色
     * @param object FilterInvocation对象，可以得到request等web资源
     * @param configAttributes 本次访问需要的权限
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (Objects.nonNull(configAttributes) && !configAttributes.isEmpty()) {
            configAttributes.forEach(configAttribute -> {
                authentication.getAuthorities().forEach(grantedAuthority->{
                    if(configAttribute.getAttribute().trim().equals(grantedAuthority.getAuthority().trim())) {
                        return;
                    }
                });
            });
            throw new AccessDeniedException("当前访问没有权限");
        }
        return;
    }

    /**
     * 表示此AccessDecisionManager是否能够处理传递的ConfigAttribute呈现的授权请求
     * @param attribute
     * @return
     */
    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    /**
     * 示当前AccessDecisionManager实现是否能够为指定的安全对象（方法调用或Web请求）提供访问控制决策
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
