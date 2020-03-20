package io.github.brenovit.ecommerce.mapper;

import java.util.List;

import io.github.brenovit.ecommerce.models.Product;
import io.github.brenovit.ecommerce.payload.product.ProductRequest;
import io.github.brenovit.ecommerce.payload.product.ProductResponse;
import lombok.experimental.UtilityClass;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@UtilityClass
public class ProductMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public Product parse(ProductRequest request){    	
    	mapperFactory.classMap(ProductRequest.class, Product.class)
    	.field("categoryId", "category.id")
    	.register();
        return mapperFactory.getMapperFacade().map(request, Product.class);
    }
    
    public ProductResponse parse(Product request){
        return mapperFactory.getMapperFacade().map(request, ProductResponse.class);
    }
    
	public List<ProductResponse> parse(List<Product> request) {
		return mapperFactory.getMapperFacade().mapAsList(request, ProductResponse.class);
	}

}
