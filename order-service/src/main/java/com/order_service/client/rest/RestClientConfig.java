package com.order_service.client.rest;

import com.order_service.client.InventoryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    // to put in config file
    private final String INVENTORY_SERVICE_URL = "http://localhost:8082";

    @Bean
    public InventoryClient inventoryClient() {
        RestClient restClient = RestClient.builder()
                .baseUrl(INVENTORY_SERVICE_URL)
                .build();
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxy = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxy.createClient(InventoryClient.class);
    }
}
