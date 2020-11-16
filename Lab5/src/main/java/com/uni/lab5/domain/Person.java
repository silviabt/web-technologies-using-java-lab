package com.uni.lab5.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Setter
@Getter
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class Person {

    private String name;
    private String surname;
    private String description;
}
