package io.github.brenovit.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.brenovit.ecommerce.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
    @Query(value="SELECT p FROM Product p WHERE "
    		+ "(p.category.id = :#{#product.category.id} or :#{#product.category.id} is null)")
	Page<Product> findAll(@Param("product") Product product, Pageable pageable);
}
