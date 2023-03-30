package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.userEntity;

public interface userRepository extends JpaRepository<userEntity, Long> {

    public userEntity findByEmail(String email);
}
