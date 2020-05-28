package com.codegym.service;

import com.codegym.model.Album;
import com.codegym.model.Song;

import java.util.List;

public interface AlbumService {
    List<Album> getAllAlbum();

    Album findById(Long id);

    void save(Album album);

    void remove(Long id);

    Album findAlbumByName(String name);
}
