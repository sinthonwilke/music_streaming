package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.albumEntity;

@Repository
public interface albumRepository extends CrudRepository<albumEntity, Long> {

    List<albumEntity> findByNameLike(String name);
    List<albumEntity> findAllByArtistId(Long artistID);
    List<albumEntity> findByIdOrNameLike(Long id, String name);
    List<albumEntity> findByNameLikeOrArtistId(String name, Long artistId);
    List<albumEntity> findByIdOrArtistId(Long id, Long artistId);
    List<albumEntity> findByIdAndArtistIdOrNameLike(Long id,Long artistId,String name);
    List<albumEntity> findByArtistIsNull();

    @Query("select m from albumEntity m where (?1 is null or id=?1) and " +
    "(?2 is null or name like %?2%) and " +
    "(?3 is null or artist=?3)"
    )
    List<albumEntity> findByAllColumn(Long id, String name, Long artist);
}
