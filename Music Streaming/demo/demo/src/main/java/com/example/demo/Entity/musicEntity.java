package com.example.demo.Entity;

import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "musics")
public class musicEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Basic @Column(nullable = false)
    private Date releaseDate;

    @ManyToOne @JoinColumn(name = "genres", referencedColumnName = "id")
    private genreEntity genre;

    @ManyToOne @JoinColumn(name = "artists", referencedColumnName = "id")
    private artistEntity artist;


    public musicEntity() {}
    public musicEntity(Long id, String name, Date releaseDate, genreEntity genre, artistEntity artist) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.artist = artist;
    }


    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public genreEntity getGenre() {
        if(this.genre == null) {
            genreEntity temp = new genreEntity(-1L, "null");
            return temp;
        }
        return this.genre;
    }
    public void setGenre(genreEntity genre) {
        this.genre = genre;
    }
    public artistEntity getArtist() {
        if(this.artist == null) {
            artistEntity temp = new artistEntity(-1L, "null");
            return temp;
        }
        return this.artist;    }
    public void setArtist(artistEntity artist) {
        this.artist = artist;
    }
}