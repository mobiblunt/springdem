package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.models.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find by email
    Optional<User> findByEmail(String email);
    
    // Find by username
    Optional<User> findByUsername(String username);
    
    // Find users by name containing
    List<User> findByNameContaining(String name);
    
    // Custom query example
    @Query("SELECT u FROM User u WHERE u.active = true")
    List<User> findActiveUsers();
    
    // Custom query with parameters
    @Query("SELECT u FROM User u WHERE u.age > :age")
    List<User> findUsersOlderThan(@Param("age") int age);
    
    // Check if exists by email
    boolean existsByEmail(String email);
}