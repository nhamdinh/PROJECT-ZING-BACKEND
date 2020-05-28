package com.codegym.repository;

import com.codegym.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Long> {
    Users findUsersByUsername (String username);
    Users findUsersByEmail(String email);
}
