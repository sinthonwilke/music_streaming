package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Entity.containerAlbumEntity;

public interface containerAlbumRepository extends JpaRepository<containerAlbumEntity, Long> {
    
    List<containerAlbumEntity> findByOrderByAlbumAsc();
    List<containerAlbumEntity> findByAlbumId(Long id);

    @Query("select m from containerAlbumEntity m where (?1 is null or album=?1) and " +
    "(?2 is null or music=?2)"
    )
    List<containerAlbumEntity> findByAllColumn(Long album_id, Long music_id);

}
