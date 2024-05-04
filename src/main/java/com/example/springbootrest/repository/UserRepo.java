package com.example.springbootrest.repository;


import com.example.springbootrest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String userName);

}
