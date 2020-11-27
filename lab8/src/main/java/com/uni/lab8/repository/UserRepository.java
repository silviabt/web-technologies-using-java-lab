package com.uni.lab8.repository;

import com.uni.lab8.domain.User;
import com.uni.lab8.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users =  new ArrayList<>();

    public User save(User user) {
        users.add(user);
        return user;
    }

    public List<User> getAll() {
        return users;
    }

    public User get(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findAny()
                .orElseThrow(() -> new EntityNotFoundException(username));
    }

}
