package com.uni.lab9.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private Long id;
    private String cnp;
    private Integer age;
    private String otherInformation;

}
