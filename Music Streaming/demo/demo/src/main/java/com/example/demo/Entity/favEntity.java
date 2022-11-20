package com.example.demo.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fav")
public class favEntity {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "users", referencedColumnName = "id")
    private userEntity user;

    @ManyToOne @JoinColumn(name = "musics", referencedColumnName = "id")
    private musicEntity music;


    public favEntity() {}
    public favEntity(Long id, userEntity user, musicEntity music) {
        this.id = id;
        this.user = user;
        this.music = music;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public userEntity getUser() {
        return user;
    }

    public void setUser(userEntity user) {
        this.user = user;
    }

    public musicEntity getMusic() {
        return music;
    }

    public void setMusic(musicEntity music) {
        this.music = music;
    }    
}
