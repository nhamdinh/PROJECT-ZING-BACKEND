package com.codegym.model;

public class FormSong {
    private String nameSong;
    private String infoSong;
    private String dateSong;
    private String likeSong;
    private String listenSong;
    private String downloadSong;
    private String commendSong;
    private String category;
    private String author;
    private String singer;
    private String album;

    public FormSong(String nameSong, String infoSong, String dateSong, String likeSong, String listenSong, String downloadSong, String commendSong, String category, String author, String singer, String album) {
        this.nameSong = nameSong;
        this.infoSong = infoSong;
        this.dateSong = dateSong;
        this.likeSong = likeSong;
        this.listenSong = listenSong;
        this.downloadSong = downloadSong;
        this.commendSong = commendSong;
        this.category = category;
        this.author = author;
        this.singer = singer;
        this.album = album;
    }

    public FormSong() {
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

    public String getDateSong() {
        return dateSong;
    }

    public void setDateSong(String dateSong) {
        this.dateSong = dateSong;
    }

    public String getLikeSong() {
        return likeSong;
    }

    public void setLikeSong(String likeSong) {
        this.likeSong = likeSong;
    }

    public String getListenSong() {
        return listenSong;
    }

    public void setListenSong(String listenSong) {
        this.listenSong = listenSong;
    }

    public String getDownloadSong() {
        return downloadSong;
    }

    public void setDownloadSong(String downloadSong) {
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }
}
