package com.api_gateway.routes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.api_gateway.routes.CircuitBreakerEndpoint;

@Configuration
public class ActuatorConfig {

    @Bean
    public CircuitBreakerEndpoint circuitBreakerEndpoint() {
        return new CircuitBreakerEndpoint();
    }
}