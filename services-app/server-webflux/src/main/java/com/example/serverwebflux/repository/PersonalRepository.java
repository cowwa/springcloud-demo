package com.example.serverwebflux.repository;

import com.example.serverwebflux.entity.Personal;
import com.example.serverwebflux.entity.QPersonal;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;

/**
 * @author: cowwa
 * @Date: 2020/1/3 11:19
 * @Description:
 */
public interface PersonalRepository extends QuerydslPredicateExecutor<Personal>,QuerydslBinderCustomizer<QPersonal>,
        JpaRepository<Personal,String> {
    /**
     * 绑定默认查询条件，如果是String类型，默认走模糊查询
     * @param bindings
     * @param root
     */
    @Override
    default void customize(final QuerydslBindings bindings, final QPersonal root) {
        bindings.bind(String.class).first((StringPath path, String value) -> path.like("%".concat(value).concat("%")));
    }
}
