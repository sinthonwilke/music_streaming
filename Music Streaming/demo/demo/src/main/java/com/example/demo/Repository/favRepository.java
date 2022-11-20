package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.favEntity;

import java.util.List;

@Repository
public interface favRepository extends CrudRepository<favEntity, Long> {
    
    List<favEntity> findByUser(Long id);
}
