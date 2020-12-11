package com.uni.lab10.service;

import com.uni.lab10.domain.User;
import com.uni.lab10.domain.UserDetails;
import com.uni.lab10.domain.UserType;
import com.uni.lab10.dto.UserDto;
import com.uni.lab10.mapper.UserMapper;
import com.uni.lab10.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    public UserDto create(UserDto userDto, UserType userType) {
        User user = userMapper.mapToEntity(userDto);
        user.setUserType(userType);
        user.setAccountCreated(LocalDateTime.now());
        UserDetails userDetails = user.getUserDetails();
        userDetails.setOtherInformation("User created with spring data jpa");
        user.setUserDetails(userDetails);

        User savedUser = userRepository.save(user);
        return userMapper.mapToDto(savedUser);
    }

    public UserDto getOne(String username) {
        User user = userRepository.findByUsername(username);

        return userMapper.mapToDto(user);
    }

    public boolean generateTwoRandomUsers() {
        User randomUser1 = User.builder()
                .username("TransactionalrandomUser3")
                .userDetails(UserDetails.builder()
                        .cnp("11111111111")
                        .build())
                .build();

        userRepository.save(randomUser1);


        User randomUser2 = User.builder()
                .username("TransactionalrandomUser4")
                .userDetails(UserDetails.builder()
                        .cnp("222222222222")
                        .build())
                .build();

        userRepository.save(randomUser2);

        return true;
    }
}
