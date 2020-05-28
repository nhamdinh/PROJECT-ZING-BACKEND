package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSong;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String nameSong;
    @NotEmpty
    @Size(max = 5000)
    private String infoSong;
    @NotEmpty
    private String imageSong;
    @NotNull
    public Date dateSong;
    @NotNull
    private Long likeSong;
    @NotNull
    private Long listenSong;

    @NotNull
    private Long downloadSong;
    @NotEmpty
    private String commendSong;
    @NotEmpty
    private String category;
    @NotEmpty
    private String author;
    @NotEmpty
    private String linkSong;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSinger")
    private Singer singer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAlbum")
    private Album album;

    public Song() {
    }

    public Song(Long idSong, @NotEmpty @Size(min = 2, max = 30) String nameSong, @NotEmpty @Size(max = 5000) String infoSong, @NotEmpty String imageSong, @NotEmpty Date dateSong, @NotEmpty Long likeSong, @NotEmpty Long listenSong, Long downloadSong, @NotEmpty String commendSong, @NotEmpty String category, @NotEmpty String author, @NotEmpty String linkSong, Singer singer, Album album) {
        this.idSong = idSong;
        this.nameSong = nameSong;
        this.infoSong = infoSong;
        this.imageSong = imageSong;
        this.dateSong = dateSong;
        this.likeSong = likeSong;
        this.listenSong = listenSong;
        this.downloadSong = downloadSong;
        this.commendSong = commendSong;
        this.category = category;
        this.author = author;
        this.linkSong = linkSong;
        this.singer = singer;
        this.album = album;
    }

    public Song(@NotEmpty @Size(min = 2, max = 30) String nameSong, @NotEmpty @Size(max = 5000) String infoSong, @NotEmpty String imageSong, @NotEmpty Date dateSong, @NotEmpty Long likeSong, @NotEmpty Long listenSong, Long downloadSong, @NotEmpty String commendSong, @NotEmpty String category, @NotEmpty String author, @NotEmpty String linkSong, Singer singer, Album album) {
        this.nameSong = nameSong;
        this.infoSong = infoSong;
        this.imageSong = imageSong;
        this.dateSong = dateSong;
        this.likeSong = likeSong;
        this.listenSong = listenSong;
        this.downloadSong = downloadSong;
        this.commendSong = commendSong;
        this.category = category;
        this.author = author;
        this.linkSong = linkSong;
        this.singer = singer;
        this.album = album;
    }

    public Long getIdSong() {
        return idSong;
    }

    public void setIdSong(Long idSong) {
        this.idSong = idSong;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getInfoSong() {
        return infoSong;
    }

    public void setInfoSong(String infoSong) {
        this.infoSong = infoSong;
    }

    public String getImageSong() {
        return imageSong;
    }

    public void setImageSong(String imageSong) {
        this.imageSong = imageSong;
    }

    public Date getDateSong() {
        return dateSong;
    }

    public void setDateSong(Date dateSong) {
        this.dateSong = dateSong;
    }

    public Long getLikeSong() {
        return likeSong;
    }

    public void setLikeSong(Long likeSong) {
        this.likeSong = likeSong;
    }

    public Long getListenSong() {
        return listenSong;
    }

    public void setListenSong(Long listenSong) {
        this.listenSong = listenSong;
    }

    public Long getDownloadSong() {
        return downloadSong;
    }

    public void setDownloadSong(Long downloadSong) {
        this.downloadSong = downloadSong;
    }

    public String getCommendSong() {
        return commendSong;
    }

    public void setCommendSong(String commendSong) {
        this.commendSong = commendSong;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLinkSong() {
        return linkSong;
    }

    public void setLinkSong(String linkSong) {
        this.linkSong = linkSong;
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}