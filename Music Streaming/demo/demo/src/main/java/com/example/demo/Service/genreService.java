package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

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

    public genreEntity findByID(Long id) {
        Optional<genreEntity> genre = repo.findById(id);
        if (genre.isPresent()) {
            return genre.get();
        }
        else {
            return null;
        }
    }

    public List<genreEntity> findByAllColumn(Long id, String name) {
        return (List<genreEntity>) repo.findByAllColumn(id, name);
    }

    public void save(genreEntity genre) {
        repo.save(genre);
    }
}
