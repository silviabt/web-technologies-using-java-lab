package com.unibuc.lab11.util;

import com.unibuc.lab11.domain.User;
import com.unibuc.lab11.domain.UserDetails;

public class UserUtil {

    public static User anUser(String username) {
        return User.builder()
                .username(username)
                .userDetails(UserDetails
                        .builder()
                        .cnp("123456789101")
                        .otherInformation("other information")
                        .build())
                .build();
    }

    public static User anUser(Long id) {
        return User.builder()
                .id(id)
                .username("username")
                .userDetails(UserDetails
                        .builder()
                        .cnp("123456789101")
                        .otherInformation("other information")
                        .build())
                .build();
    }
}
