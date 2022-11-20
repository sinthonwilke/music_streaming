package com.example.demo.playlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class playlistService {
    
    @Autowired
    private playlistRepository repo;

    public List<playlistEntity> findAll() {
        return(List<playlistEntity>) repo.findAll();
    }


}
