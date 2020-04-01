package com.example.serveroauth.repository;

import com.example.serveroauth.model.QRole;
import com.example.serveroauth.model.QUser;
import com.example.serveroauth.model.Role;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：RoleRepository
 * 类 描 述：TODO
 * 创建时间：2020/3/18 11:11
 *
 * @author：cowwa
 */
public interface RoleRepository extends QuerydslPredicateExecutor<Role>, QuerydslBinderCustomizer<QRole>,
        JpaRepository<Role,Long> {

    @Override
    default void customize(final QuerydslBindings bindings, final QRole root) {
        bindings.bind(String.class).first((StringPath path, String value) -> path.like("%".concat(value).concat("%")));
    }
}
