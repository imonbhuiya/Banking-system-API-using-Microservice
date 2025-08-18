package com.banking.microservices.product.dto;

import java.math.BigDecimal;

public record ProductRequest(String id, String name, BigDecimal price, String description) {
}
