package com.codegym.service.Impl;

import com.codegym.model.Album;
import com.codegym.repository.AlbumRepository;
import com.codegym.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    List<Album> albumList = new LinkedList<>();

    @Override
    public List<Album> getAllAlbum() {
        List<Album> albums = (List<Album>) this.albumRepository.findAll();
        albumList.addAll(albums);
        return albums;
    }

    @Override
    public Album findAlbumByName(String name) {
        if (albumList.size() == 0) {
            albumList = getAllAlbum();
        }
        for (Album a : albumList) {
            if (a.getNameAlbum().equals(name))
                return a;
        }
        return null;
    }

    @Override
    public Album findById(Long id) {
        return albumRepository.findOne(id);
    }

    @Override
    public void save(Album album) {
        albumRepository.save(album);
    }

    @Override
    public void remove(Long id) {
        albumRepository.delete(id);
    }
}
