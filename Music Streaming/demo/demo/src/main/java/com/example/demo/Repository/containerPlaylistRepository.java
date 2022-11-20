package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.containerPlaylistEntity;

@Repository
public interface containerPlaylistRepository extends CrudRepository<containerPlaylistEntity, Long> {
    
    List<containerPlaylistEntity> findByOrderByPlaylistAsc();
    
}
