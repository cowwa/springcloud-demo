package com.example.serverbusgateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @author: cowwa
 * @Date: 2020/1/2 15:07
 * @Description: 限流配置
 */
@Configuration
public class RateLimiterConfig {


    /**
     * 基于请求路径的限流
      * @return
     */
    @Bean
    KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
        //return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
        //return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }
}
