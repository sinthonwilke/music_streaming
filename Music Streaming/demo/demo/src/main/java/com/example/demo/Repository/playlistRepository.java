package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Entity.playlistEntity;

public interface playlistRepository extends CrudRepository<playlistEntity, Long> {

    List<playlistEntity> findByUserId(Long id);

}
