package io.github.brenovit.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brenovit.ecommerce.models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
