package com.example.SpringSecurity.config;

import com.example.SpringSecurity.entity.User;
import com.example.SpringSecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findById(username);
        User user = null;
        if (optionalUser.isPresent())
        {
            user=optionalUser.get();
        }
        else {
            throw new UsernameNotFoundException("User not found: "+username);
        }

        return new CustomUserDetails(user);
    }
}
