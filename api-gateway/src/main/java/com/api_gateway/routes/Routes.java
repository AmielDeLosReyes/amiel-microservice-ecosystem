package com.api_gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class Routes {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("order-service", r -> r.path("/order/**")
                        .filters(f -> f
                                .circuitBreaker(c -> c
                                        .setName("orderServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallbackRoute"))
                        )
                        .uri("http://localhost:8081"))
                .route("inventory-service", r -> r.path("/inventory/**")
                        .filters(f -> f
                                .circuitBreaker(c -> c
                                        .setName("inventoryServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallbackRoute"))
                        )
                        .uri("http://localhost:8082"))
                .route("user-service", r -> r.path("/user/**")
                        .filters(f -> f
                                .circuitBreaker(c -> c
                                        .setName("userServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallbackRoute"))
                        )
                        .uri("http://localhost:8083"))
                .route("product-service", r -> r.path("/product/**")
                        .filters(f -> f
                                .circuitBreaker(c -> c
                                        .setName("productServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallbackRoute"))
                        )
                        .uri("http://localhost:8084"))
                .route("sample-service", r -> r.path("/sample/**")
                        .filters(f -> f
                                .circuitBreaker(c -> c
                                        .setName("sampleServiceCircuitBreaker")
                                        .setFallbackUri("forward:/fallbackRoute"))
                        )
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

    @Bean
    public RouterFunction<ServerResponse> fallbackRoute() {
        return route()
                .GET("/fallbackRoute", request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE)
                        .bodyValue("Service Unavailable, please try again later."))
                .build();
    }
}
