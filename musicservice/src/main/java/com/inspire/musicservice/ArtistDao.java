package com.inspire.musicservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ArtistDao extends CrudRepository<Artist, Integer> {
    List<Artist> findByName(String name);
    List<Artist> findByNameContainingIgnoreCase(String name);
}