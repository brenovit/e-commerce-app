package io.github.brenovit.ecomerce.mapper;


import static io.github.brenovit.ecommerce.mapper.ProductMapper.parse;

import java.math.BigDecimal;

import org.junit.Test;

import io.github.brenovit.ecommerce.models.Product;
import io.github.brenovit.ecommerce.models.ProductCategory;
import io.github.brenovit.ecommerce.payload.product.ProductRequest;
import io.github.brenovit.ecommerce.payload.product.ProductResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ProductMapperTest {

	@Test
	public void testParseProductRequest() {
		ProductRequest request = new ProductRequest();
		request.setCategoryId(10L);
		request.setDescription("Descritption of product");
		request.setName("Name of product");
		request.setSku("sku");
		request.setUnitPrice(new BigDecimal("45.9"));
		request.setUnitsInStock(20);
		request.setImageUrl(null);
		Product response = parse(request);
		log.info(response.toString());
	}
	
	@Test
	public void testParseProduct() {
		Product request = new Product();
		request.setCategory(new ProductCategory(15L));
		request.setDescription("Descritption of product");
		request.setName("Name of product");
		request.setSku("sku");
		request.setUnitPrice(new BigDecimal("45.9"));
		request.setUnitsInStock(20);
		request.setImageUrl(null);
		ProductResponse response = parse(request);
		log.info(response.toString());
	}
}
