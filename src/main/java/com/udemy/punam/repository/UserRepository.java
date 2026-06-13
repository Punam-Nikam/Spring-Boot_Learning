package com.udemy.punam.repository;

import com.udemy.punam.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    
}
