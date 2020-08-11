package io.github.brenovit.luvshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.brenovit.luvshop.models.Permission;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}