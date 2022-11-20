package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.userEntity;
import com.example.demo.Repository.userRepository;
import com.example.demo.User.userDetail;

@Service
public class userService implements UserDetailsService{

    @Autowired
    private userRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        userEntity user = repo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found.");
        }
        return new userDetail(user);
    }
    
}
