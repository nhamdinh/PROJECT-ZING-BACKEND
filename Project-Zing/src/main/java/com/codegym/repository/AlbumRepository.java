package com.codegym.repository;

import com.codegym.model.Album;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AlbumRepository extends PagingAndSortingRepository<Album,Long> {
}
