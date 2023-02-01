package com.cognizant.User.controller;

import com.cognizant.User.model.User;
import com.cognizant.User.model.UserDto;
import com.cognizant.User.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserServiceImp userService;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody UserDto dto) {
        User user = new User(dto.getId(), dto.getUsername(), null);
        return userService.saveUser(user);
    }
}
