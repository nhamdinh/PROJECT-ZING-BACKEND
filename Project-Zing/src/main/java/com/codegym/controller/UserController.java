package com.codegym.controller;

import com.codegym.model.Role;
import com.codegym.model.UserClientAuthen;
import com.codegym.model.UserLogin;
import com.codegym.model.Users;
import com.codegym.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private Role roleUser;

    @Autowired
    private Role roleAdmin;

    @PostMapping("api/register")
    public ResponseEntity<Void> saveUsers(@RequestBody Users users) {
        Users usersSearch = usersService.findByUserName(users.getusername());
        if(usersSearch==null && usersService.findByEmail(users.getEmail())==null) {
            users.setRole(roleUser);
            usersService.save(users);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserClientAuthen> doLogin(@RequestBody UserLogin userLogin) {
        Users user = this.usersService.findByUserName(userLogin.getUsername());
        UserClientAuthen userClientAuthen=null;
        if (user != null) {
            if (user.getPassword().equals(userLogin.getPassword())) {
                 userClientAuthen = new UserClientAuthen(
                        user.getId(),
                        user.getusername(),
                        user.getPassword(),
                        user.getRole().getRole(),
                        "fake-jwt-token." + user.getId()
                );
            } else {
                userClientAuthen = null;
            }
        }
        return new ResponseEntity<UserClientAuthen>(userClientAuthen, HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable("id") Long id) {
        Users user = this.usersService.findById(id);
        return new ResponseEntity<Users>(user, HttpStatus.OK);
    }
}
