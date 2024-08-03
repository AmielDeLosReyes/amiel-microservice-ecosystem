package com.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Routes {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r.path("/order/**")
                        .uri("http://localhost:8081"))
                .route("inventory-service", r -> r.path("/inventory/**")
                        .uri("http://localhost:8082"))
                .route("user-service", r -> r.path("/user/**")
                        .uri("http://localhost:8083"))
                .route("product-service", r -> r.path("/product/**")
                        .uri("http://localhost:8084"))
                .route("sample-service", r -> r.path("/sample/**")
                        .uri("http://localhost:8086"))
                // Swagger routes with RewritePath filter
                .route("order-service-swagger", r -> r.path("/aggregate/order-service/v3/api-docs")
                        .filters(f -> f.rewritePath("/aggregate/order-service/v3/api-docs", "/api-docs"))
                        .uri("http://localhost:8081"))
                .route("inventory-service-swagger", r -> r.path("/aggregate/inventory-service/v3/api-docs")
                        .filters(f -> f.rewritePath("/aggregate/inventory-service/v3/api-docs", "/api-docs"))
                        .uri("http://localhost:8082"))
                .route("user-service-swagger", r -> r.path("/aggregate/user-service/v3/api-docs")
                        .filters(f -> f.rewritePath("/aggregate/user-service/v3/api-docs", "/api-docs"))
                        .uri("http://localhost:8083"))
                .route("product-service-swagger", r -> r.path("/aggregate/product-service/v3/api-docs")
                        .filters(f -> f.rewritePath("/aggregate/product-service/v3/api-docs", "/api-docs"))
                        .uri("http://localhost:8084"))
                .route("sample-service-swagger", r -> r.path("/aggregate/sample-service/v3/api-docs")
                        .filters(f -> f.rewritePath("/aggregate/sample-service/v3/api-docs", "/api-docs"))
                        .uri("http://localhost:8086"))
                .build();
    }
}
