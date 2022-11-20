package com.example.demo.containerAlbum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class containerAlbumService {
    
    @Autowired
    private containerAlbumRepository repo;

    public List<containerAlbumEntity> findAll() {
        return (List<containerAlbumEntity>) repo.findByOrderByAlbumAsc();
    }
}
