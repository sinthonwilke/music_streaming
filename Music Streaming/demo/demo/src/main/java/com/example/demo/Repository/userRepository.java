package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.userEntity;

@Repository
public interface userRepository extends JpaRepository<userEntity, Long> {

    public userEntity findByEmail(String email);
}
