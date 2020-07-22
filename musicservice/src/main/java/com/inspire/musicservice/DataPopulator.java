package com.inspire.musicservice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataPopulator {
   
    @Autowired
    private ArtistDao artistDao;

    @Autowired
    private AlbumDao albumDao;

    @Autowired
    private TrackDao trackDao;

    @PostConstruct
    private void postConstruct() {
        
        Artist a = new Artist();
        a.setName("Pink Floyd");
        artistDao.save(a);

        System.out.println("Loaded artist id is " + a.getId());

        Album album = new Album();
        album.setTitle("The Wall");
        albumDao.save(album);
        
        Track t = new Track("Hey You");
        // t.setAlbum(album);
        List<Track> tracks = new ArrayList<>();
        tracks.add(t);
        tracks.add(new Track("Is There Anybody Out There?"));
        tracks.add(new Track("Nobody Home"));
        tracks.add(new Track("Vera"));
        tracks.add(new Track("Bring the Boys Back Home"));
        tracks.add(new Track("Comfortably Numb"));
        trackDao.saveAll(tracks);

        album.setTracks(tracks);
        Set<Album> albums = new HashSet<>();
        albums.add(album);
        albumDao.saveAll(albums);
        
        a.setAlbums(albums);
        album.setArtist(a);
        albumDao.save(album);

        artistDao.save(a);

        System.out.println(artistDao.findByName("Pink Floyd").get(0).getAlbums().size() + " albums");
        
    }
        
}