package com.example.demo.genre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface genreRepository extends CrudRepository<genreEntity, Long> {

    List<genreEntity> findByOrderByIdAsc();
}
