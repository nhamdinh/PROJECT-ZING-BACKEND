package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SongCRUDController {
    @Autowired
    private SongService songService;

    @GetMapping("/api/song")
    public Iterable getAllSong() {
        return songService.findAll();
    }

    @PostMapping("/api/song")
    public ResponseEntity<Iterable<Song>> addSong(@RequestBody Song song) {
        songService.save(song);
        System.out.println(song.getIdSong());
        return new ResponseEntity<Iterable<Song>>(getAllSong(), HttpStatus.CREATED);
    }


    @DeleteMapping("/api/song/{idSong}")
    public ResponseEntity<Iterable<Song>> deleteSong(@ModelAttribute("song") Song song) {
        songService.remove(song.getIdSong());

        return new ResponseEntity<Iterable<Song>>(getAllSong(), HttpStatus.OK);
    }


    @PutMapping("/api/song/{idSong}")
    public ResponseEntity<Song> editAuthor(@RequestBody Song song) {
        songService.save(song);

        return new ResponseEntity<Song>(songService.findById(song.getIdSong()), HttpStatus.CREATED);
    }

}
