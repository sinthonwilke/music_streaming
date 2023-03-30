package com.example.demo.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Entity.artistEntity;

public interface artistRepository extends CrudRepository<artistEntity, Long> {
    
    List<artistEntity> findByOrderByIdAsc();
    List<artistEntity> findByIdOrNameLike(Long id, String name);

    @Query("select m from artistEntity m where (?1 is null or id=?1) and " +
        "(?2 is null or name like %?2%)"
        )
    List<artistEntity> findByAllColumn(Long id, String name);
    
}
