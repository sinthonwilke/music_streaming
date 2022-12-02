package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.playlistEntity;
import com.example.demo.Repository.playlistRepository;

@Service
public class playlistService {
    
    @Autowired
    private playlistRepository repo;

    public List<playlistEntity> findAll() {
        return(List<playlistEntity>) repo.findAll();
    }

    public List<playlistEntity> findByUserId(Long id) {
        return(List<playlistEntity>) repo.findByUserId(id);
    }

    public void save(playlistEntity playlist) {
        repo.save(playlist);
    }

}
