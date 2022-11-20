package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.albumEntity;

@Repository
public interface albumRepository extends CrudRepository<albumEntity, Long> {
    
}
