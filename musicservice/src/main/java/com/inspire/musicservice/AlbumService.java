package com.inspire.musicservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumService{
    
    @Autowired
    private AlbumDao albumDao;

    public List<Album> findByTitleContaining(String name){
        return albumDao.findByTitleContainingIgnoreCase(name);
    }
}