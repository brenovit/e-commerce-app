package io.github.brenovit.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.brenovit.ecommerce.exception.ResourceNotFoundException;
import io.github.brenovit.ecommerce.models.ProductCategory;
import io.github.brenovit.ecommerce.repository.ProductCategoryRepository;
import lombok.SneakyThrows;

@Service
public class ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository repository;
	
	public List<ProductCategory> findAll(){
		return repository.findAll();
	}
	
	@SneakyThrows
	public ProductCategory findById(Long id){
		Optional<ProductCategory> product = repository.findById(id);
		if(!product.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return product.get();
	}
	
	public ProductCategory save (ProductCategory request) {
		return repository.save(request);
	}


	public ProductCategory update(Long id, ProductCategory request) {
		findById(id);
		return repository.save(request);
	}	
	
	@SneakyThrows
	public ProductCategory delete(Long id) {
		ProductCategory productCategory = findById(id);
		repository.deleteById(id);
		return productCategory;
	}
}
