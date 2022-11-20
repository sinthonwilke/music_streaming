package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.artistEntity;
import com.example.demo.Repository.artistRepository;

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
