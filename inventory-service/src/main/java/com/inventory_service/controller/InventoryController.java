package com.inventory_service.controller;

import com.inventory_service.servicefacade.InventoryServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryServiceFacade inventoryServiceFacade;

    @GetMapping("/is-in-stock")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventoryServiceFacade.isInStock(skuCode, quantity);
    }

}
