package com.example.demo.fav;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface favRepository extends CrudRepository<favEntity, Long> {
    
    List<favEntity> findByUser(Long id);
}
