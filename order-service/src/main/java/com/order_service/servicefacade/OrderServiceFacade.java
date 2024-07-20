package com.order_service.servicefacade;

import com.order_service.dto.request.OrderRequest;
import org.springframework.stereotype.Service;

@Service
public interface OrderServiceFacade {

    void placeOrder(OrderRequest orderRequest);
}
