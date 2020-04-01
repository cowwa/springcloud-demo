package com.example.serveroauth.model;

import com.example.serveroauth.common.BaseEntity;
import com.querydsl.core.BooleanBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：Permission
 * 类 描 述：TODO
 * 创建时间：2020/3/18 14:40
 *  资源权限
 * @author：cowwa
 */
@Api(value = "资源权限")
@Entity
@Table(name = "permission",schema = "public")
@Data
@EqualsAndHashCode(callSuper = false)
public class Permission extends BaseEntity  implements Serializable {

    @ApiModelProperty(value = "主键")
    @Column(unique=true,length=64)
    @Id
    private Long id;

    @ApiModelProperty(value = "名称")
    @Column(length=128)
    private String name;

    @ApiModelProperty(value = "路由")
    @Column(length=128)
    private String url;

    @ApiModelProperty(value = "描述")
    @Column(length=100)
    private String description;

    @ApiModelProperty(value = "父ID")
    @Column(length=64)
    private Long pid;


    /**
     * 一个角色拥有多个权限，一个权限可以被多个角色拥有
     */
    @JoinTable(name = "permission_role",
            joinColumns= {
                    @JoinColumn(name = "permission_id", referencedColumnName = "id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id",
                            nullable = false, updatable = false)})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Role> roleSet=new HashSet<>();

    @Override
    public BooleanBuilder builderQuery() {
        return null;
    }
}
