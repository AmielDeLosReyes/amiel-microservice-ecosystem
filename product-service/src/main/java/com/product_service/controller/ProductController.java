package com.product_service.controller;

import com.product_service.controller.dto.request.ProductRequest;
import com.product_service.controller.dto.response.ProductResponse;
import com.product_service.servicefacade.ProductServiceFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceFacade productServiceFacade;

    @PostMapping("/create-product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productServiceFacade.createProduct(productRequest);
    }

    @GetMapping("get-all-products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productServiceFacade.findAllProducts();
    }
}
