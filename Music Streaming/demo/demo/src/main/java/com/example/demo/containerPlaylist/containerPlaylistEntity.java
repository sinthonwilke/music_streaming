package com.example.demo.containerPlaylist;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.example.demo.music.musicEntity;
import com.example.demo.playlist.playlistEntity;

@Entity
@Table(name = "playlist_music")
public class containerPlaylistEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne @JoinColumn(name = "playlists", referencedColumnName = "id")
    private playlistEntity playlist;

    @ManyToOne @JoinColumn(name = "musics", referencedColumnName = "id")
    private musicEntity music;

    
    public containerPlaylistEntity() {}
    public containerPlaylistEntity(long id, playlistEntity playlist, musicEntity music) {
        this.id = id;
        this.playlist = playlist;
        this.music = music;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public playlistEntity getPlaylist() {
        return playlist;
    }

    public void setPlaylist(playlistEntity playlist) {
        this.playlist = playlist;
    }

    public musicEntity getMusic() {
        return music;
    }

    public void setMusic(musicEntity music) {
        this.music = music;
    }
}
