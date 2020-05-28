package com.codegym.service.Impl;

import com.codegym.model.Song;
import com.codegym.repository.SongRepository;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;

public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public Iterable<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findOne(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public void remove(Long id) {
        songRepository.delete(id);
    }
}
