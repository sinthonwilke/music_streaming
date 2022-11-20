package com.example.demo.containerAlbum;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface containerAlbumRepository extends CrudRepository<containerAlbumEntity, Long> {
    
    List<containerAlbumEntity> findByOrderByAlbumAsc();

}
