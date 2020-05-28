package com.codegym.service.Impl;

import com.codegym.model.Singer;
import com.codegym.repository.SingerRepository;
import com.codegym.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerRepository singerRepository;

    List<Singer> singersMap = new LinkedList<>();

    @Override
    public List<Singer> getAllSinger() {
        List<Singer> singers = (List<Singer>) this.singerRepository.findAll();
        singersMap.addAll(singers);
        return singers;
    }

    @Override
    public Singer findSingerByName(String name) {
        if (singersMap.size() == 0) {
            singersMap = getAllSinger();
        }
        for (Singer s : singersMap) {
            if (s.getNameSinger().equals(name)) {
                return s;
            }
        }
        return null;
    }
}
