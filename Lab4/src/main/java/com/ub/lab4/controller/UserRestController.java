package com.ub.lab4.controller;

import com.ub.lab4.model.User;
import com.ub.lab4.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(User user) {
        System.out.println(String.format("Request to save user: %s", user.getUsername()));
        userService.save(user);

        return user;
    }

    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") Long id) {
        System.out.println(String.format("Request to get user: %s", id));
        return this.userService.get(id);
    }

}
