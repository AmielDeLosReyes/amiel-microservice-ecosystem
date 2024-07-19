package com.product_service.servicefacade;

import com.product_service.controller.dto.request.ProductRequest;
import com.product_service.controller.dto.response.ProductResponse;
import com.product_service.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductServiceFacade {

    ProductResponse createProduct(ProductRequest productRequest);

    List<ProductResponse> findAllProducts();
}
