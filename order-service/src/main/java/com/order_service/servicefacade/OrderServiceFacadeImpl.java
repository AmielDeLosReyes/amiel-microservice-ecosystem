package com.order_service.servicefacade;


import com.order_service.client.InventoryClient;
import com.order_service.dto.request.OrderRequest;
import com.order_service.model.Order;
import com.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceFacadeImpl implements OrderServiceFacade {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @Override
    public void placeOrder(OrderRequest orderRequest) {

        // Call to inventory-service
        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
            log.info("Order placed successfully");
        } else {
            throw new RuntimeException("Product with skuCode " + orderRequest.skuCode() + " is not in stock.");
        }

    }
}
