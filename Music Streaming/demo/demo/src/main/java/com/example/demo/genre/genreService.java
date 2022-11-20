package com.example.demo.genre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class genreService {
    
    @Autowired
    private genreRepository repo;

    public List<genreEntity> findAll() {
        return (List<genreEntity>) repo.findByOrderByIdAsc();
    }
}
