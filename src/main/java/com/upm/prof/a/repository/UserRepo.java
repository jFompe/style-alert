package com.upm.prof.a.repository;

import java.util.Optional;

import com.upm.prof.a.persistence.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{
    
    public Optional<User> findById(Long id);

    public User findByEmail(String email);
}
