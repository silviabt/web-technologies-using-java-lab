package com.uni.lab9.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String fullName;
    private UserDetails userDetails;
    private UserType userType;
    private LocalDateTime accountCreated;

}
