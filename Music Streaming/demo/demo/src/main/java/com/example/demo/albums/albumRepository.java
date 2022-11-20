package com.example.demo.albums;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface albumRepository extends CrudRepository<albumEntity, Long> {
    
}
