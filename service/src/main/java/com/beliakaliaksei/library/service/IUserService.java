package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {
    List<User> getAllUsers();
    void addNewUser(User user);
    void editUser(User user, long id);
    User getById(long id);
    UserDetails loadUserByUsername(String email);
}
