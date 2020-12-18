package com.unibuc.lab11.util;

import com.unibuc.lab11.dto.UserDto;

public class UserDtoUtil {

    public static UserDto aUserDto(String username) {
        return UserDto
                .builder()
                .username(username)
                .cnp("123456789101")
                .otherInformation("other information")
                .build();
    }

    public static UserDto aUserDto(Long id) {
        return UserDto
                .builder()
                .id(id)
                .username("username")
                .cnp("123456789101")
                .otherInformation("other information")
                .build();
    }

}
