package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.User;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.exception.UserNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {
    List<User> getAllUsers();
    void addNewUser(User user) throws SuchEmailAlreadyExistsException;
    void editUser(User user, long id) throws UserNotFoundException;
    UserDetails loadUserByUsername(String email);
    void encryptUserPassword(User user);
    boolean isUserWithSuchEmailAlreadyExists(User user);
    boolean isUserWithSuchEmailAlreadyExistsExcludedCurrentUser(User user, long id);
}
