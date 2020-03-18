package io.github.brenovit.ecommerce.payload.product;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private String description;
}
