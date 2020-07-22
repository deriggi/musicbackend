package com.inspire.musicservice;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Album implements MusicElement{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String type = "Album";
    @Override
    public String getType() {
        return type;
    }
    
    @Column
    private String title;

    @ManyToOne
    @JsonIgnore
    private Artist artist;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Track> tracks;

    public Album(){
    }

    public Artist getArtist(){
        return artist;
    }

    public void setArtist(Artist a){
        this.artist = a;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setTracks(List<Track> tracks){
        this.tracks = tracks;
    }

    public List<Track> getTracks(){
        return tracks;
    }

    

}