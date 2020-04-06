package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.User;


import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAllUsers();
    void addNewUser(User user);
    void editUser(User user, long id);
    User getById(long id);
   // UserDetails loadUserByUsername(String email);
}
