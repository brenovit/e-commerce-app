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

import io.github.brenovit.ecommerce.models.Product;
import io.github.brenovit.ecommerce.payload.product.ProductRequest;
import io.github.brenovit.ecommerce.payload.product.ProductResponse;
import io.github.brenovit.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ProductRestController {

	private final ProductService service;
		
	@GetMapping	
	public ResponseEntity<List<Product>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}		

	@PostMapping
	public ResponseEntity<ProductResponse> create(@Valid @RequestBody ProductRequest product) {
		return ResponseEntity.ok(service.save(product));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProductResponse> update(@PathVariable Long id, @Valid @RequestBody ProductRequest product) {
		return ResponseEntity.ok(service.update(id, product));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Product> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
