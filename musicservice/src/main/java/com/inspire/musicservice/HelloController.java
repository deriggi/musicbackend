package com.inspire.musicservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Autowired
    private ArtistService artistService;

    @Autowired
    private AlbumService albumService;

    @CrossOrigin(origins = "http://localhost:1234")
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
	public ResponseEntity<?> getArtists() throws Exception {
	    return ResponseEntity.ok(artistService.findByName("Pink Floyd"));
    }

    @CrossOrigin(origins = "http://localhost:1234")
    @RequestMapping(value = "/search/{term}", method = RequestMethod.GET)
	public ResponseEntity<?> search(@PathVariable("term") String term) throws Exception {
        
        List<? extends MusicElement> combined = union(artistService.findByNameContaining(term), albumService.findByTitleContaining(term));
	    return ResponseEntity.ok( combined );
    }

   private  <E> List<E> union(List<? extends E> a,List<? extends E> b){
        List<E> es= new ArrayList<E>();
        es.addAll(a);
        es.addAll(b);
        return es;
    }

}