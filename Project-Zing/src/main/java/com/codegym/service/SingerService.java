package com.codegym.service;

import com.codegym.model.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> getAllSinger();
    Singer findSingerByName(String name);
}
