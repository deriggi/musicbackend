package com.inspire.musicservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlbumDao extends CrudRepository<Album, Integer> {

    List<Album> findByTitle(String title);
    List<Album> findByTitleContainingIgnoreCase(String title);
    
}