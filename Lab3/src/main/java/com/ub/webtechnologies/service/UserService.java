package com.ub.webtechnologies.service;

import com.ub.webtechnologies.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    public User createUser(String name, int age) {
        System.out.println(String.format("Request to create user %s", name));

        User.UserBuilder builder = new User.UserBuilder();
        User user = builder
                .name(name)
                .age(age)
                .build();

        System.out.println(String.format("User %s - created", name));
        return user;
    }
}
