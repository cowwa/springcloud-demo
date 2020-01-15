package com.example.serverbusgateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * 整合各个服务的swagger
 * Created by ChenChang on 2017/8/2.
 */
@Configuration
@EnableSwagger2
@Profile("swagger")
public class Swagger2Config {
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {
        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
            resources.add(swaggerResource("downtime-demo", "/downtime-demo/v2/api-docs", "2.0"));
            resources.add(swaggerResource("mybatisplus-demo", "/mybatisplus-demo/v2/api-docs", "2.0"));
            resources.add(swaggerResource("datajpa-demo", "/datajpa-demo/v2/api-docs", "2.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }
}