package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.containerPlaylistEntity;
import com.example.demo.Repository.containerPlaylistRepository;

@Service
public class containerPlaylistService {
    
    @Autowired
    private containerPlaylistRepository repo;

    public List<containerPlaylistEntity> findAll() {
        return (List<containerPlaylistEntity>) repo.findByOrderByPlaylistAsc();
    }
}
