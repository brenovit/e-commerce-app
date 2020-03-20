package io.github.brenovit.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.brenovit.ecommerce.models.ProductCategory;
import io.github.brenovit.ecommerce.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products/categories")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ProductCategoryRestController {

	private final ProductCategoryService service;
		
	@GetMapping	
	public ResponseEntity<List<ProductCategory>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}		

	@PostMapping
	public ResponseEntity<ProductCategory> create(@Valid @RequestBody ProductCategory product) {
		return ResponseEntity.ok(service.save(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductCategory> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductCategory> update(@PathVariable Long id, @Valid @RequestBody ProductCategory product) {
		return ResponseEntity.ok(service.update(id, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ProductCategory> delete(@PathVariable Long id) {
		return ResponseEntity.ok(service.delete(id));
	}
}
