package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

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

    public albumEntity findById(Long id) throws Exception{
        Optional<albumEntity> album = repo.findById(id);
        if (album.isPresent()) {
            return album.get();
        }
        throw new Exception();
    }

    public List<albumEntity> findByAllColumn(Long id, String name, Long artistID) {
        return (List<albumEntity>) repo.findByAllColumn(id, name, artistID);
    }
    
    public void save(albumEntity album){
        repo.save(album);
    }

    public void deleteByID(Long id) {
        repo.deleteById(id);
    }

    public List<albumEntity> findByName(String name) {
        return (List<albumEntity>) repo.findByName(name);
    }
}
