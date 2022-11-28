package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "playlists")
public class playlistEntity {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne @JoinColumn(name = "users", referencedColumnName = "id")
    private userEntity user;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.REMOVE)
    private List<containerPlaylistEntity> cae;


    public playlistEntity() {}
    public playlistEntity(Long id, userEntity user, String name) {
        this.id = id;
        this.user = user;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
