package com.unibuc.lab11.service;

import com.unibuc.lab11.domain.User;
import com.unibuc.lab11.domain.UserDetails;
import com.unibuc.lab11.domain.UserType;
import com.unibuc.lab11.dto.UserDto;
import com.unibuc.lab11.exception.AnotherEntityNotFoundException;
import com.unibuc.lab11.exception.EntityNotFoundException;
import com.unibuc.lab11.mapper.UserMapper;
import com.unibuc.lab11.repository.UserRepository;
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

    public UserDto getOne(String username) throws AnotherEntityNotFoundException {
        User user = userRepository.findByUsername(username);
        if(null == user) {
            throw new AnotherEntityNotFoundException(username);
        }

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
