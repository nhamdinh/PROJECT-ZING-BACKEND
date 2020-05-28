package com.codegym.service;

import com.codegym.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> usersList ();
    List<Users> findAll();
    Users findById(Long id);
    void save(Users users);
    void delete(Users users);
    Users findByUserName(String username);
    Users findByEmail(String email);
}
