package com.example.demo.containerPlaylist;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface containerPlaylistRepository extends CrudRepository<containerPlaylistEntity, Long> {
    
    List<containerPlaylistEntity> findByOrderByPlaylistAsc();
    
}
