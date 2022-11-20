package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.genreEntity;
import com.example.demo.Repository.genreRepository;

@Service
public class genreService {
    
    @Autowired
    private genreRepository repo;

    public List<genreEntity> findAll() {
        return (List<genreEntity>) repo.findByOrderByIdAsc();
    }
}
