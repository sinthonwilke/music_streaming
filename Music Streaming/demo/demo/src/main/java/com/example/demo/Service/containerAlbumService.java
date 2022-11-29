package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

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

    public List<containerAlbumEntity> findByAllColumn(Long album_id, Long music_id) {
        return (List<containerAlbumEntity>) repo.findByAllColumn(album_id, music_id);
    }

    public void save(containerAlbumEntity containerAlbum) {
        repo.save(containerAlbum);
    }

    public containerAlbumEntity findByID(Long id) {
        Optional<containerAlbumEntity> containerAlbum = repo.findById(id);
        if (containerAlbum.isPresent()) {
            return containerAlbum.get();
        }
        else {
            return null;
        }
    }

    public void deleteByID(Long id) {
        repo.deleteById(id);
    }

    public List<containerAlbumEntity> findByAlbumID(Long album_id) {
        return (List<containerAlbumEntity>) repo.findByAlbum(album_id);
    }
}
