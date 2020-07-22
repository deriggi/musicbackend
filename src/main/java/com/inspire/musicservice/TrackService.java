package com.inspire.musicservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackService {
    
    @Autowired
    private TrackDao trackDao;

    public List<Track> findByTitleContainingIgnoreCase(String title){
        return trackDao.findByTitleContainingIgnoreCase(title);
    }
    
}