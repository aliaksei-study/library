package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User getAuthenticatedUser(@AuthenticationPrincipal User user) {
        return user;
    }
}
