package com.ub.lab4.service;

import com.ub.lab4.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void save(User user) {
        System.out.println(String.format("Request to save user: %s", user.getUsername()));
    }

    public User get(Long id) {
        System.out.println(String.format("Request to get user with id: %s", id));
        return User.builder().username("Testing get").build();
    }
}
