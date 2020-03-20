package io.github.brenovit.ecommerce.payload.product;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ProductResponse{
    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private String description;
    private Date createdAt;
    private Date updatedAt;
}
