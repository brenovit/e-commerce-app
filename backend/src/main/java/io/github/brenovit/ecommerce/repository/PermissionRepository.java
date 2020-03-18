package io.github.brenovit.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.brenovit.ecommerce.models.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}