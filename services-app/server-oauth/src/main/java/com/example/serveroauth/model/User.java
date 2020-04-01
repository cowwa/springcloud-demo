package com.example.serveroauth.model;

import com.example.serveroauth.common.BaseEntity;
import com.querydsl.core.BooleanBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：User
 * 类 描 述：TODO
 * 创建时间：2020/3/18 10:46
 * 创 建 人：cowwa
 * @author cowwa
 */
@Api(value = "用户信息")
@Entity
@Table(name="user",schema = "public")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity implements UserDetails, Serializable {
    @ApiModelProperty(value = "主键")
    @Column(unique=true,length=64)
    @Id
    private Long id;

    @ApiModelProperty(value = "用户名")
    @Column(length=128)
    private String username;

    @ApiModelProperty(value = "密码")
    @Column(length=128)
    private String password;

    @ApiModelProperty(value = "用户角色")
    @JoinTable(name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Role> roleSet = new HashSet<>();

    @Override
    public BooleanBuilder builderQuery() {
        return null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    /**
     * 用户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户是够锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是够可用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
