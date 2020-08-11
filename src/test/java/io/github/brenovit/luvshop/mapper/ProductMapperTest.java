package io.github.brenovit.luvshop.mapper;


import static io.github.brenovit.luvshop.mapper.ProductMapper.parse;

import java.math.BigDecimal;

import org.junit.Test;

import io.github.brenovit.luvshop.models.Product;
import io.github.brenovit.luvshop.models.ProductCategory;
import io.github.brenovit.luvshop.payload.product.ProductRequest;
import io.github.brenovit.luvshop.payload.product.ProductResponse;
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
