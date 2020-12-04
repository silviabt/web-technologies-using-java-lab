package com.uni.lab9.service;

import com.uni.lab9.domain.User;
import com.uni.lab9.domain.UserType;
import com.uni.lab9.dto.UserDto;
import com.uni.lab9.mapper.UserMapper;
import com.uni.lab9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public UserDto create(UserDto userDto, UserType userType) {
        User user = userMapper.mapToEntity(userDto);
        user.setUserType(userType);

        User savedUser = userRepository.save(user);
        return userMapper.mapToDto(savedUser);
    }

    public UserDto getOne(String username) {
        User user = userRepository.get(username);

        return userMapper.mapToDto(user);
    }
}
