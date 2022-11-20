package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.albumEntity;
import com.example.demo.Repository.albumRepository;

@Service
public class albumService {
    
    @Autowired
    private albumRepository repo;

    public List<albumEntity> findAll() {
        return (List<albumEntity>) repo.findAll();
    }
}
