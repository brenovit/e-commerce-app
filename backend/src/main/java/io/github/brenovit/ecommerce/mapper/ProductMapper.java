package io.github.brenovit.ecommerce.mapper;

import io.github.brenovit.ecommerce.models.Product;
import io.github.brenovit.ecommerce.payload.product.ProductRequest;
import io.github.brenovit.ecommerce.payload.product.ProductResponse;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class ProductMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    @SneakyThrows
    public Product parse(ProductRequest request){
        return mapperFactory.getMapperFacade().map(request, Product.class);
    }

    @SneakyThrows
    public ProductResponse parse(Product request){
        return mapperFactory.getMapperFacade().map(request, ProductResponse.class);
    }
}
