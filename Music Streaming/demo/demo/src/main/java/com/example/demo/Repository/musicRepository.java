package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.Entity.musicEntity;
import java.util.List;

public interface musicRepository extends JpaRepository<musicEntity, Long> {

    List<musicEntity> findByIdOrNameLike(Long id, String name);
    List<musicEntity> findByArtist(Long id);
    List<musicEntity> findByNameLike(String name);


    @Query("select m from musicEntity m where year(m.releaseDate)=?1 order by rand()")
    List<musicEntity> findByYear(Integer year);

    @Query("select m from musicEntity m order by rand()")
    List<musicEntity> getRand();

    @Query("select m from musicEntity m where m.artist.name like %?1%")
    List<musicEntity> findByArtistNameLike(String name);

    @Query("select m from musicEntity m where m.genre.name like %?1% order by rand()")
    List<musicEntity> findByGenreNameLike(String genre);

    @Query("select m from musicEntity m where (?1 is null or id=?1) and " +
        "(?2 is null or name like %?2%) and " +
        "(?3 is null or year(m.releaseDate)=?3) and " +
        "(?4 is null or genre=?4 or genre=null) and " +
        "(?5 is null or artist=?5 or artist=null)"
        )
    List<musicEntity> findByAllColumn(Long id, String name, Integer release, Long genre, Long artist);
    
}