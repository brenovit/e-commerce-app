package io.github.brenovit.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brenovit.ecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	//List<Product> findByUserId(Long user);
	
	//@Query("SELECT p FROM Product p WHERE p.id = :id AND p.user.id = :userId")
	//Optional<Product> findByIdAndUserId(Long id, Long userId);
	Page<Product> findByCategoryId(Long id, Pageable pageable);

}
