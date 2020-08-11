package io.github.brenovit.luvshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brenovit.luvshop.models.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{

}
