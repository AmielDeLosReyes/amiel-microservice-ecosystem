package com.order_service.controller;

import com.order_service.dto.request.OrderRequest;
import com.order_service.servicefacade.OrderServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceFacade orderServiceFacade;

    @PostMapping("/place-order")
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest) {
        orderServiceFacade.placeOrder(orderRequest);
        return "Order Placed Successfully.";
    }
}
