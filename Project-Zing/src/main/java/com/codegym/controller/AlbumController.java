//package com.codegym.controller;
//
//import com.codegym.model.Album;
//import com.codegym.model.FormAlbum;
//import com.codegym.service.AlbumService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.util.FileCopyUtils;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.ParseException;
//
//@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//public class AlbumController {
//    @Autowired
//    private Environment environment;
//    @Autowired
//    private AlbumService albumService;
//
//    @PostMapping(value = "/create-album", consumes = "multipart/form-data")
//    @ResponseBody
//    public ResponseEntity<?> addPostAlbum(@RequestPart(value = "imageAlbum") MultipartFile fileImage
//            , @ModelAttribute FormAlbum formAlbum) {
//        String imageName = fileImage.getOriginalFilename();
//        String imageUpload = environment.getProperty("image_upload").toString();
//        try {
//            FileCopyUtils.copy(fileImage.getBytes(), new File(imageUpload + imageName));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Album album = null;
//        album = new Album(formAlbum.getNameAlbum(), imageName);
//        this.albumService.save(album);
//
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//}
