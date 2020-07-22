package com.inspire.musicservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Track implements MusicElement{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String title;

    public Track(){}

    @ManyToOne
    @JsonIgnore
    private Album album;
    
    public Album getAlbum(){
        return this.album;
    }

    public void setAlbum(Album a){
        this.album = a;
    }

    public Track(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    private final String type = "Track";
    @Override
    public String getType() {
        return type;
    }
    
}