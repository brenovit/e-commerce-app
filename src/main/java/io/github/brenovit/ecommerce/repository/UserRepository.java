package io.github.brenovit.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import io.github.brenovit.ecommerce.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
    @Query(value="select u from User u where u.username = :username or u.email = :username")    
	Optional<User> findByUsernameOrEmail(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}
