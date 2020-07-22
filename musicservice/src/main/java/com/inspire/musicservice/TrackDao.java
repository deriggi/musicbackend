package com.inspire.musicservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TrackDao extends CrudRepository<Track, Integer> {

    List<Track> findByTitle(String title);
    List<Track> findByTitleContainingIgnoreCase(String titlePart);
    
}