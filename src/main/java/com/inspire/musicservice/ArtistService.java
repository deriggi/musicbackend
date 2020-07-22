package com.inspire.musicservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService{

    @Autowired
    private ArtistDao artistDao;

    public List<Artist> findByName(String name){        
        return artistDao.findByName(name);
    }

    public List<Artist> findByNameContaining(String name){
        return artistDao.findByNameContainingIgnoreCase(name);
    }
    
}