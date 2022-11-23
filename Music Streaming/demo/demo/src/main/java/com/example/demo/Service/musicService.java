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

    @Autowired private musicRepository repo;

    public void save(musicEntity music) {
        repo.save(music);
    }

    public List<musicEntity> FindAll() {
        return(List<musicEntity>) repo.findAll();
    }

    public List<musicEntity> findByAllColumn(Long id, String name, Integer release, Long genre, Long artist) {
        if(id == null & name == "" && release == null && genre == null && artist == null) {
            return (List<musicEntity>) repo.findAll();
        }
        return (List<musicEntity>) repo.findByAllColumn(id, name, release, genre, artist);
    }

    public musicEntity findByID(Long id) throws musicNotFoundException {
        Optional<musicEntity> music = repo.findById(id);
        if (music.isPresent()) {
            return music.get();
        }
        throw new musicNotFoundException("Could not find any music id: " + id);
    }

    public void deleteByID(Long id) throws Exception {
        repo.deleteById(id);
    }

    public String getMusicPath(String id) {
        return ("/assets/musics/" + id + ".wav");
    }

    public List<musicEntity> findByArtist(Long id) {
        return(List<musicEntity>) repo.findByArtist(id);
    }
}