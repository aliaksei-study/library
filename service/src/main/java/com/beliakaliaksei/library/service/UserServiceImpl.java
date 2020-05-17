package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.User;
import com.beliakaliaksei.library.exception.SuchEmailAlreadyExistsException;
import com.beliakaliaksei.library.exception.UserNotFoundException;
import com.beliakaliaksei.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addNewUser(User user) throws SuchEmailAlreadyExistsException {
        if (isUserWithSuchEmailAlreadyExists(user)) {
            throw new SuchEmailAlreadyExistsException("User with such email already exists");
        } else {
            encryptUserPassword(user);
            userRepository.save(user);
        }
    }

    @Override
    public void editUser(User user, long id) throws UserNotFoundException {
        User savedUser = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        savedUser.setEmail(user.getEmail());
        savedUser.setPassword(user.getPassword());
        savedUser.setRole(user.getRole());
        encryptUserPassword(savedUser);
        userRepository.save(savedUser);
    }

    @Override
    public User getById(long id) {
        return userRepository.findById(id).orElse(new User());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.loadUserByUsername(email);
    }

    @Override
    public void encryptUserPassword(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @Override
    public boolean isUserWithSuchEmailAlreadyExists(User user) {
        return loadUserByUsername(user.getEmail()) != null;
    }

    @Override
    public boolean isUserWithSuchEmailAlreadyExistsExcludedCurrentUser(User user, long id) {
        User userWithSameEmail = (User) loadUserByUsername(user.getEmail());
        if(userWithSameEmail == null) {
            return false;
        } else {
            return userWithSameEmail.getId() != id;
        }
    }
}
