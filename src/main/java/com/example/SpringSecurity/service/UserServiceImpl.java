package com.example.SpringSecurity.service;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void autoLoad()
    {
        User u1 = new User("SachinNandanwal",passwordEncoder.encode("Sachin@123"),"ADMIN");
        User u2 = new User("KeertiNandanwal",passwordEncoder.encode("Keerti@123"),"LEARNER");
        User u3 = new User("SudipSarkar",passwordEncoder.encode("Sudip@123"),"ADMIN");
        User u4 = new User("ShubhamRaj",passwordEncoder.encode("Shubham@123"),"LEARNER");

        addUser(u1);
        addUser(u2);
        addUser(u3);
        addUser(u4);
    }

    @Override
    public User addUser(User user) {
        User existingUser = getUser(user.getUserName());
        if (existingUser == null) {
            return userRepository.save(user);
        }

        return null;
    }

    @Override
    public User getUser(String userName) {
        Optional<User> userOptional = userRepository.findById(userName);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
