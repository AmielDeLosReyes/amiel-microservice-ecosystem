package com.api_gateway.routes;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/actuator/circuitbreakers")
public class CircuitBreakerEndpoint {

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @GetMapping
    public Map<String, Object> getCircuitBreakers() {
        Map<String, Object> circuitBreakers = new HashMap<>();
        circuitBreakerRegistry.getAllCircuitBreakers().forEach(cb -> {
            CircuitBreaker.Metrics metrics = cb.getMetrics();
            Map<String, Object> details = new HashMap<>();
            details.put("state", cb.getState().toString()); // Correct method to get state
            details.put("failureRate", metrics.getFailureRate());
            details.put("slowCallRate", metrics.getSlowCallRate());
            details.put("totalCalls", metrics.getNumberOfBufferedCalls() + metrics.getNumberOfFailedCalls() + metrics.getNumberOfSuccessfulCalls());
            details.put("successfulCalls", metrics.getNumberOfSuccessfulCalls());
            details.put("failedCalls", metrics.getNumberOfFailedCalls());
            details.put("slowCalls", metrics.getNumberOfSlowCalls());
            circuitBreakers.put(cb.getName(), details);
        });
        return circuitBreakers;
    }
}
