package com.example.springbootrest.service;


import com.example.springbootrest.model.User;
import com.example.springbootrest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Autowired
    private UserRepo userRepo;

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());

        return userRepo.save(user);
    }

}
