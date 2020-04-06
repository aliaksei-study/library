package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.UserDto;
import com.beliakaliaksei.library.entity.User;

import com.beliakaliaksei.library.service.IUserService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void addUser(@Valid @RequestBody UserDto userDto) {
        userService.addNewUser(Mapper.map(userDto, User.class));
    }
}
