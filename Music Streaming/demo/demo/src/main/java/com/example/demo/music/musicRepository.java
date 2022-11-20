package com.example.demo.music;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface musicRepository extends CrudRepository<musicEntity, Long> {
    List<musicEntity> findByIdOrNameLike(Long id, String name);
}
