package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "singers")
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSinger;
    @NotEmpty
    private String nameSinger;
    @NotEmpty
    private String infoSinger;
    @NotEmpty
    private String imageSinger;

//    @OneToMany(targetEntity = Song.class)
//    private List<Song> songs;

    public Singer() {
    }

    public Singer(Long idSinger, String nameSinger, String infoSinger, String imageSinger) {
        this.idSinger = idSinger;
        this.nameSinger = nameSinger;
        this.infoSinger = infoSinger;
        this.imageSinger = imageSinger;
    }

    public Long getIdSinger() {
        return idSinger;
    }

    public void setIdSinger(Long idSinger) {
        this.idSinger = idSinger;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getInfoSinger() {
        return infoSinger;
    }

    public void setInfoSinger(String infoSinger) {
        this.infoSinger = infoSinger;
    }

    public String getImageSinger() {
        return imageSinger;
    }

    public void setImageSinger(String imageSinger) {
        this.imageSinger = imageSinger;
    }

//    public List<Song> getSongs() {
//        return songs;
//    }
//
//    public void setSongs(List<Song> songs) {
//        this.songs = songs;
//    }
}
