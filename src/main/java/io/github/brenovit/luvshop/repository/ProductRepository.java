package io.github.brenovit.luvshop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.brenovit.luvshop.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
    @Query(value="SELECT p FROM Product p WHERE "
    		+ "(p.category.id = :#{#product.category.id} OR :#{#product.category.id} IS NULL ) "
    		+ "AND (p.name like %:#{#product.name}% OR :#{#product.name} IS NULL)")
	Page<Product> findAll(@Param("product") Product product, Pageable pageable);
}
