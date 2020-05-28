package com.codegym.service.Impl;

import com.codegym.model.Users;
import com.codegym.repository.UsersRepository;
import com.codegym.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersRepository usersRepository;
    public static HashMap<String, String> userDetail = new HashMap<>();
    public static List<Users> users = new LinkedList<>();

    @Override
    public List<Users> usersList() {
        List<Users> user = (List<Users>) this.usersRepository.findAll();
        users = user;
        for (Users u : users) {
            userDetail.put(u.getusername(), u.getPassword());
        }
        return user;
    }

    @Override
    public List<Users> findAll() {
        List<Users> usersList =(List<Users>) usersRepository.findAll();
        return null;
    }

    @Override
    public Users findById(Long id) {
        Users user = usersRepository.findOne(id);
        return user;
    }

    @Override
    public void save(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void delete(Users users) {
        usersRepository.delete(users);
    }

    @Override
    public Users findByUserName(String username) {
        if (users.size() == 0) {
            users = usersList();
        }
        System.out.println(users.size());
        for (Users u : users) {
            if (u.getusername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findUsersByEmail(email);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Users users=usersRepository.findUsersByUserName(username);
//        List<GrantedAuthority> authorities=new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(users.getRole().getAuthority()));
//        User user=new User(users.getUserName(),users.getPassword(),authorities);
//        return user;

}
