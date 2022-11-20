package com.example.demo.fav;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class favService {
    
    @Autowired
    private favRepository repo;

    public void save(favEntity fav) {
        repo.save(fav);
    }

    public List<favEntity> findAll() {
        return(List<favEntity>) repo.findAll();
    }

    public List<favEntity> findByUser(Long id) {
        return(List<favEntity>) repo.findByUser(id);
    }}
