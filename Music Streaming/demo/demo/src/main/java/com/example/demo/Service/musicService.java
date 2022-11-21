package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.musicEntity;
import com.example.demo.Exception.musicNotFoundException;
import com.example.demo.Repository.musicRepository;

import java.util.List;
import java.util.Optional;

@Service
public class musicService {

    @Autowired
    private musicRepository repo;

    public void save(musicEntity music) {
        repo.save(music);
    }

    public List<musicEntity> FindAll() {
        return(List<musicEntity>) repo.findAll();
    }

    public List<musicEntity> findByAllColumn(Long id, String name) {
        return(List<musicEntity>) repo.findByIdOrNameLike(id, "%"+name+"%");
    }

    public musicEntity findByID(Long id) throws musicNotFoundException {
        Optional<musicEntity> music = repo.findById(id);
        if (music.isPresent()) {
            return music.get();
        }
        throw new musicNotFoundException("Could not find any music id: " + id);
    }

    public void deleteByID(Long id) throws musicNotFoundException {
        if (!repo.existsById(id)) {
            throw new musicNotFoundException("Could not find any music id: " + id);
        }
        repo.deleteById(id);
    }

    public String getMusicPath(String id) {
        return ("/assets/musics/" + id + ".wav");
    }

    public List<musicEntity> findByArtist(Long id) {
        return(List<musicEntity>) repo.findByArtist(id);
    }

    // public void updateMusicsArtist(Long id) {

    // }
}