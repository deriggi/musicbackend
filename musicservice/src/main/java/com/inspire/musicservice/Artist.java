package com.inspire.musicservice;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Artist implements MusicElement{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Album> albums;

    public Long getId(){
        return id;
    }
    
    public Set<Album> getAlbums(){
        return albums;
    }

    public void setAlbums(Set<Album> a){
        this.albums = a;
    }

    public Artist() {
    }

    public Artist(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private final String type = "Artist";
    @Override
    public String getType() {
        return type;
    }


}