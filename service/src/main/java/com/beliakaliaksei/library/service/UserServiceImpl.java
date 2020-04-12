package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.User;
import com.beliakaliaksei.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void editUser(User user, long id) {
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.loadUserByUsername(email);
    }
}
