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
                .build();
    }


//    @Bean
//    public RouterFunction<ServerResponse> orderServiceRoute() {
//        return GatewayRouterFunctions.route("order_service")
//                .route(RequestPredicates.path("/order"), HandlerFunctions.http("http://localhost:8081"))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> inventoryServiceRoute() {
//        return GatewayRouterFunctions.route("inventory_service")
//                .route(RequestPredicates.path("/inventory"), HandlerFunctions.http("http://localhost:8082"))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> userServiceRoute() {
//        return GatewayRouterFunctions.route("user_service")
//                .route(RequestPredicates.path("/user"), HandlerFunctions.http("http://localhost:8083"))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> productServiceRoute() {
//        return GatewayRouterFunctions.route("product_service")
//                .route(RequestPredicates.path("/product"), HandlerFunctions.http("http://localhost:8084"))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> sampleServiceRoute() {
//        return GatewayRouterFunctions.route("sample_service")
//                .route(RequestPredicates.path("/sample"), HandlerFunctions.http("http://localhost:8086"))
//                .build();
//    }


}
