package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.musicEntity;
import java.util.List;

@Repository
public interface musicRepository extends JpaRepository<musicEntity, Long> {

    List<musicEntity> findByIdOrNameLike(Long id, String name);
    List<musicEntity> findByArtist(Long id);

    @Query("select m from musicEntity m where (?1 is null or id=?1) and " +
        "(?2 is null or name like %?2%) and " +
        "(?3 is null or year(m.releaseDate)=?3) and " +
        "(?4 is null or genre=?4) and " +
        "(?5 is null or artist=?5)"
        )
    List<musicEntity> findByAllColumn(Long id, String name, Integer release, Long genre, Long artist);
    
}