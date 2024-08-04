package com.product_service.controller.dto.response;

import java.math.BigDecimal;

public record ProductResponse(String id, String skuCode, String name, String description, String price) {
}
