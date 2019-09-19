package com.lv.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args){
        SpringApplication.run(GatewayApplication.class,args);
    }

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        // @formatter:off
        return builder.routes()
                .route(r -> r.path("/fluent/customer/**")
                        .filters(f -> f.stripPrefix(2)
                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
                        .uri("lb://SPRING-CLOUD-CONFIG-CLIENT")
                        .order(0)
                        .id("spring-cloud-config-client")
                )
                .build();
        // @formatter:on
    }
}
