package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.artistEntity;

@Repository
public interface artistRepository extends CrudRepository<artistEntity, Long> {
    
    List<artistEntity> findByOrderByIdAsc();
    List<artistEntity> findByIdOrNameLike(Long id, String name);

}
