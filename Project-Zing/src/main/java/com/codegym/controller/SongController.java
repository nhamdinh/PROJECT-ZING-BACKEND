package com.codegym.controller;

import com.codegym.model.Album;
import com.codegym.model.FormSong;
import com.codegym.model.Singer;
import com.codegym.model.Song;
import com.codegym.service.AlbumService;
import com.codegym.service.SingerService;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.Response;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SongController {

    @Autowired
    private SongService songService;
    @Autowired
    private Environment environment;
    @Autowired
    private AlbumService albumService;
    @Autowired
    private SingerService singerService;


    @GetMapping("/api/songs")
    @ResponseBody
    public List<Song> getListCustomers() {
        List<Song> songs = (List<Song>) songService.findAll();
        return songs;
    }


    @RequestMapping(value = "/songs/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Song> updateCustomer(@PathVariable("id") Long id, @RequestBody Song song) {
        System.out.println("Updating Song " + id);

        Song currentSong = songService.findById(id);

        if (currentSong == null) {
            System.out.println("Song with id " + id + " not found");
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }

        currentSong.setNameSong(song.getNameSong());
        currentSong.setInfoSong(song.getInfoSong());
        currentSong.setImageSong(song.getImageSong());
        currentSong.setDateSong(song.getDateSong());
        currentSong.setLikeSong(song.getLikeSong());
        currentSong.setListenSong(song.getListenSong());
        currentSong.setDownloadSong(song.getDownloadSong());
        currentSong.setCommendSong(song.getCommendSong());

        songService.save(currentSong);
        return new ResponseEntity<Song>(currentSong, HttpStatus.OK);
    }

    @GetMapping("/api/singer")
    @ResponseBody
    public List<Singer> getAllSinger() {
        List<Singer> singers = this.singerService.getAllSinger();
        return singers;
    }

    @GetMapping("/api/album")
    @ResponseBody
    public List<Album> getAllAlbum() {
        List<Album> albums = this.albumService.getAllAlbum();
        return albums;
    }


    @RequestMapping(value = "/songs/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Song> deleteCustomer(@PathVariable("id") Long id) {
        System.out.println("Fetching & Deleting Song with id " + id);

        Song song = songService.findById(id);
        if (song == null) {
            System.out.println("Unable to delete. Song with id " + id + " not found");
            return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
        }

        songService.remove(id);
        return new ResponseEntity<Song>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/create-song", consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity<?> addPost(@RequestPart(value = "imageSong") MultipartFile fileImage, @RequestPart(value = "linkSong") MultipartFile fileAudio
            , @ModelAttribute FormSong formSong) {
        String imageName = fileImage.getOriginalFilename();
        String audioName = fileAudio.getOriginalFilename();
        System.out.println(audioName);
        String imageUpload = environment.getProperty("image_upload").toString();
        String audioUpload = environment.getProperty("audio_upload").toString();
        try {
            FileCopyUtils.copy(fileImage.getBytes(), new File(imageUpload + imageName));
            FileCopyUtils.copy(fileAudio.getBytes(), new File(audioUpload + audioName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Singer singer = this.singerService.findSingerByName(formSong.getSinger().toString());
        Album album = this.albumService.findAlbumByName(formSong.getAlbum());
        if (singer == null || album == null) {
            System.out.println("null");
            return new ResponseEntity<Error>(HttpStatus.BAD_REQUEST);
        }

        Song song = null;
        try {
            song = new Song(formSong.getNameSong(), formSong.getInfoSong(), imageName
                    , new SimpleDateFormat("dd-MM-yyyy").parse(formSong.getDateSong()), Long.parseLong(formSong.getLikeSong()),
                    Long.parseLong(formSong.getListenSong()), Long.parseLong(formSong.getDownloadSong()),
                    formSong.getCommendSong(), formSong.getCategory(), formSong.getAuthor(), audioName, singer, album);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.songService.save(song);


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
