package com.codegym.service;

import com.codegym.model.Song;

public interface SongService {

    Iterable<Song> findAll();

    Song findById(Long id);

    void save(Song song);

    void remove(Long id);
}
