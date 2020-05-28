package io.github.brenovit.ecommerce.mapper;

import java.util.List;

import io.github.brenovit.ecommerce.models.Product;
import io.github.brenovit.ecommerce.models.ProductCategory;
import io.github.brenovit.ecommerce.payload.product.ProductCategoryResponse;
import io.github.brenovit.ecommerce.payload.product.ProductRequest;
import io.github.brenovit.ecommerce.payload.product.ProductResponse;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ProductMapper {
    private static MapperFactory mapperFactory;

    static {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    public static Product parse(ProductRequest request){    	
    	mapperFactory.classMap(ProductRequest.class, Product.class)
    	.field("categoryId", "category.id")
    	.register();
        return mapperFactory.getMapperFacade().map(request, Product.class);
    }
  
    public static ProductResponse parse(Product request){
    	mapperFactory
    	.classMap(Product.class, ProductResponse.class)
    	.field("category.id", "categoryId").byDefault()
    	.register();
        return mapperFactory.getMapperFacade().map(request, ProductResponse.class);
    }
    
    public static ProductCategoryResponse parse(ProductCategory request){
        return mapperFactory.getMapperFacade().map(request, ProductCategoryResponse.class);
    }
    
    public static List<ProductCategoryResponse> parseCategory(List<ProductCategory> request) {
		return mapperFactory.getMapperFacade().mapAsList(request, ProductCategoryResponse.class);
	}
    
	public static List<ProductResponse> parse(List<Product> request) {
		mapperFactory.classMap(Product.class, ProductResponse.class)
		.field("category.id", "categoryId").byDefault()
    	.register();
		return mapperFactory.getMapperFacade().mapAsList(request, ProductResponse.class);
	}

}
