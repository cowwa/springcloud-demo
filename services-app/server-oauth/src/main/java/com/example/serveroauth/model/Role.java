package com.example.serveroauth.model;

import com.example.serveroauth.common.BaseEntity;
import com.querydsl.core.BooleanBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：Role
 * 类 描 述：TODO
 * 创建时间：2020/3/18 10:57
 * 创 建 人：cowwa
 * @author cowwa
 *
 * Authentication实现类都保存了一个GrantedAuthority列表，其表示用户所具有的权限。
 * GrantedAuthority是通过AuthenticationManager设置到Authentication对象中的，
 * 然后AccessDecisionManager将从Authentication中获取用户所具有的GrantedAuthority来鉴定用户是否具有访问对应资源的权限
 *
 */
@Api(value = "角色信息")
@Entity
@Table(name = "role",schema = "public")
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseEntity implements GrantedAuthority {

    @ApiModelProperty(value = "主键")
    @Column(unique=true,length=64)
    @Id
    private Long id;

    @ApiModelProperty(value = "角色名称")
    @Column(length=128)
    private String name;


    @Override
    public BooleanBuilder builderQuery() {
        return null;
    }

    /**
     * 权限点
     * @return
     */
    @Override
    public String getAuthority() {
        return name;
    }
}
