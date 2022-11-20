package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.containerAlbumEntity;

@Repository
public interface containerAlbumRepository extends CrudRepository<containerAlbumEntity, Long> {
    
    List<containerAlbumEntity> findByOrderByAlbumAsc();

}
