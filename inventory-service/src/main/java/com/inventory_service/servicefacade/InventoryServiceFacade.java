package com.inventory_service.servicefacade;

import org.springframework.stereotype.Service;

@Service
public interface InventoryServiceFacade {
    boolean isInStock(String skuCode, Integer quantity);
}
