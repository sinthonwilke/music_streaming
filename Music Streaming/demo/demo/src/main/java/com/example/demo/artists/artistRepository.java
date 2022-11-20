package com.example.demo.artists;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface artistRepository extends CrudRepository<artistEntity, Long> {
    
    List<artistEntity> findByOrderByIdAsc();
}
