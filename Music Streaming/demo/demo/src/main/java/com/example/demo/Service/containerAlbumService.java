package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.containerAlbumEntity;
import com.example.demo.Repository.containerAlbumRepository;

@Service
public class containerAlbumService {
    
    @Autowired
    private containerAlbumRepository repo;

    public List<containerAlbumEntity> findAll() {
        return (List<containerAlbumEntity>) repo.findByOrderByAlbumAsc();
    }

}
