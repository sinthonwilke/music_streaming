package com.example.demo.Repository;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.containerPlaylistEntity;

@Repository
public interface containerPlaylistRepository extends CrudRepository<containerPlaylistEntity, Long> {
    
    List<containerPlaylistEntity> findByOrderByPlaylistAsc();
    List<containerPlaylistEntity> findByPlaylistId(Long id);

    @Transactional
    void deleteByPlaylistIdAndMusicId(Long playlistId, Long musicId);    
}
