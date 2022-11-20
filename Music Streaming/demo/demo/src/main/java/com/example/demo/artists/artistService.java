package com.example.demo.artists;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class artistService {
    
    @Autowired
    private artistRepository repo;

    public List<artistEntity> findAll() {
        return  (List<artistEntity>) repo.findByOrderByIdAsc();
    }

    public artistEntity findByID(Long id) {
        Optional<artistEntity> artist = repo.findById(id);
        if (artist.isPresent()) {
            return artist.get();
        }
        else {
            return null;
        }
    }

}
