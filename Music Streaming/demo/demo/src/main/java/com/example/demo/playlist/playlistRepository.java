package com.example.demo.playlist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface playlistRepository extends CrudRepository<playlistEntity, Long> {

}
