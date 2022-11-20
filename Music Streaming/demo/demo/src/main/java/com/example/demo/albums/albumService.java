package com.example.demo.albums;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class albumService {
    
    @Autowired
    private albumRepository repo;

    public List<albumEntity> findAll() {
        return (List<albumEntity>) repo.findAll();
    }
}
