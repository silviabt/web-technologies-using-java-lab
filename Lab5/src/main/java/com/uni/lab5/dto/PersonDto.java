package com.uni.lab5.dto;

import lombok.Builder;
import lombok.Getter;

//@Setter
@Getter
@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class PersonDto {

    private String name;
    private String surname;
    private String additionalInfo;
}
