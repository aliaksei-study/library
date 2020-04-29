package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.AuthenticatedUserDto;
import com.beliakaliaksei.library.dto.UserDto;
import com.beliakaliaksei.library.entity.User;

import com.beliakaliaksei.library.service.IUserService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;
import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {
    
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public User getAuthenticatedUser(@AuthenticationPrincipal User user) {
        return user;
    }
}
