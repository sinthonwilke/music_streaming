package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "album_music")
public class containerAlbumEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "albums", referencedColumnName = "id")
    private albumEntity album;

    @ManyToOne @JoinColumn(name = "musics", referencedColumnName = "id")
    private musicEntity music;


    public containerAlbumEntity() {}
    public containerAlbumEntity(Long id, albumEntity album, musicEntity music) {
        this.id = id;
        this.album = album;
        this.music = music;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public albumEntity getAlbum() {
        if(this.album == null) {
            albumEntity temp = new albumEntity(-1L, null, "null");
            return temp;
        }
        return this.album;    }

    public void setAlbum(albumEntity album) {
        this.album = album;
    }

    public musicEntity getMusic() {
        if(this.music == null) {
            musicEntity temp = new musicEntity(-1L, "null", null, null, null);
            return temp;
        }
        return this.music;    }

    public void setMusic(musicEntity music) {
        this.music = music;
    }
    
}
