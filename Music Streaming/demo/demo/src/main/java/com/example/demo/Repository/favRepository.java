package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Entity.favEntity;
import java.util.List;

public interface favRepository extends CrudRepository<favEntity, Long> {
    
    List<favEntity> findByUserId(Long id);
    List<favEntity> findByUserIdAndMusicId(Long user, Long music);

    @Transactional
    void deleteByUserIdAndMusicId(Long user, Long music);
}
