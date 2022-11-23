package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "albums")
public class albumEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "artists", referencedColumnName = "id")
    private artistEntity artist;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "music", cascade = CascadeType.REMOVE)
    private List<containerAlbumEntity> cae;

    public albumEntity() {}
    public albumEntity(Long id, artistEntity artist, String name) {
        this.id = id;
        this.artist = artist;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public artistEntity getArtist() {
        if(this.artist == null) {
            artistEntity temp = new artistEntity(-1L, "null");
            return temp;
        }
        return this.artist;
    }

    public void setArtist(artistEntity artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
