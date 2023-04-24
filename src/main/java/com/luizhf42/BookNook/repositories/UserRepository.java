package com.luizhf42.BookNook.repositories;

import com.luizhf42.BookNook.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String username);
}
