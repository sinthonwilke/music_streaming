package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.containerAlbumEntity;

@Repository
public interface containerAlbumRepository extends JpaRepository<containerAlbumEntity, Long> {
    
    List<containerAlbumEntity> findByOrderByAlbumAsc();

}
