package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.musicEntity;
import java.util.List;

@Repository
public interface musicRepository extends JpaRepository<musicEntity, Long> {

    List<musicEntity> findByIdOrNameLike(Long id, String name);
    List<musicEntity> findByArtist(Long id);
}