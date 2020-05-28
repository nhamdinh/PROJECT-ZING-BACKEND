package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAlbum;
    @NotEmpty
    private String nameAlbum;
    @NotEmpty
    @Size(max = 5000)
    private String infoAlbum;
    @NotEmpty
    private String imageAlbum;

//    @OneToMany(targetEntity = Song.class)
//    private List<Song> songs;

    public Album() {
    }

    public Album(@NotEmpty String nameSong, @NotEmpty String imageAlbum) {
        this.nameAlbum = nameSong;
        this.imageAlbum = imageAlbum;


    }
    public Album(Long idAlbum, String nameAlbum, String infoAlbum, String imageAlbum) {
        this.idAlbum = idAlbum;
        this.nameAlbum = nameAlbum;
        this.infoAlbum = infoAlbum;
        this.imageAlbum = imageAlbum;
    }


    public Long getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Long idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public String getInfoAlbum() {
        return infoAlbum;
    }

    public void setInfoAlbum(String infoAlbum) {
        this.infoAlbum = infoAlbum;
    }

    public String getImageAlbum() {
        return imageAlbum;
    }

    public void setImageAlbum(String imageAlbum) {
        this.imageAlbum = imageAlbum;
    }

//    public List<Song> getSongs() {
//        return songs;
//    }
//
//    public void setSongs(List<Song> songs) {
//        this.songs = songs;
//    }
}
