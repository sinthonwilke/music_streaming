package com.example.demo.containerPlaylist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class containerPlaylistService {
    
    @Autowired
    private containerPlaylistRepository repo;

    public List<containerPlaylistEntity> findAll() {
        return (List<containerPlaylistEntity>) repo.findByOrderByPlaylistAsc();
    }
}
