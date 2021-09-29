package com.example.demo.controllers;

import com.example.demo.dto.UserDto;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }

}
