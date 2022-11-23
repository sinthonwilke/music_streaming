package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.genreEntity;

@Repository
public interface genreRepository extends CrudRepository<genreEntity, Long> {

    List<genreEntity> findByOrderByIdAsc();
    List<genreEntity> findByNameLike(String name);
    List<genreEntity> findByIdOrNameLike(Long id, String name);

}
