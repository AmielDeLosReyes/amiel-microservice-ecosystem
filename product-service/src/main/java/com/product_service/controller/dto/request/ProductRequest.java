package com.product_service.controller.dto.request;

public record ProductRequest(String skuCode, String id,String name, String description, String price) {
}
