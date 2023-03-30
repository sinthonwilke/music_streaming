package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Entity.genreEntity;

public interface genreRepository extends CrudRepository<genreEntity, Long> {

    List<genreEntity> findByOrderByIdAsc();
    List<genreEntity> findByNameLike(String name);
    List<genreEntity> findByIdOrNameLike(Long id, String name);
    
    @Query("select m from genreEntity m where (?1 is null or id=?1) and " +
    "(?2 is null or name like %?2%)"
    )
    List<genreEntity> findByAllColumn(Long id, String name);

}
