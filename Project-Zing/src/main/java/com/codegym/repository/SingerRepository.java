package com.codegym.repository;

import com.codegym.model.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SingerRepository extends PagingAndSortingRepository<Singer,Long> {
}
