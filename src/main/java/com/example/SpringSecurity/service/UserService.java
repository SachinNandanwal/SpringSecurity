package com.example.SpringSecurity.service;

import com.example.SpringSecurity.entity.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public User getUser(String userName);

    public List<User> getAllUsers();

}
