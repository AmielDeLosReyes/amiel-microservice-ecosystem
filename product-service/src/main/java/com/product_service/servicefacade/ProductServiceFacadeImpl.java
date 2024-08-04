package com.product_service.servicefacade;

import com.product_service.controller.dto.request.ProductRequest;
import com.product_service.controller.dto.response.ProductResponse;
import com.product_service.model.Product;
import com.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceFacadeImpl implements ProductServiceFacade {
    private final ProductRepository productRepository;


    // TODO: when created, add to the inventory
    @Override
    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .skuCode(productRequest.skuCode())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        productRepository.save(product);
        log.info("Product created successfully: {}", productRequest);
        return new ProductResponse(product.getId(), product.getSkuCode(), product.getName(),product.getDescription() , product.getPrice());
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        log.info("Fetching all products");
        List<Product> products = productRepository.findAll();
        log.info("Products fetched from repository: {}", products);

        List<ProductResponse> productResponses = products.stream()
                .map(product -> {
                    ProductResponse response = new ProductResponse(product.getId(), product.getSkuCode(), product.getName(), product.getDescription(), product.getPrice());
                    log.debug("Mapping product to response: {}", response);
                    return response;
                })
                .toList();

        log.info("Mapped products to responses: {}", productResponses);
        return productResponses;
    }
}
