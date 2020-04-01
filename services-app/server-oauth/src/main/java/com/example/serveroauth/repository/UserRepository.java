package com.example.serveroauth.repository;

import com.example.serveroauth.model.QUser;
import com.example.serveroauth.model.User;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：UserRepository
 * 类 描 述：TODO
 * 创建时间：2020/3/18 11:09
 *
 * @author：cowwa
 */
public interface UserRepository extends QuerydslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser>,
        JpaRepository<User,Long> {
   User findByUsername(String username);

   @Override
   default void customize(final QuerydslBindings bindings, final QUser root) {

   }

}
