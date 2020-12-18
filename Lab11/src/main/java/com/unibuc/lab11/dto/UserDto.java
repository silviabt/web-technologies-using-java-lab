package com.unibuc.lab11.dto;

import com.unibuc.lab11.validators.OnlyLetters;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @NotNull(message = "This field is required.")
    @OnlyLetters
    private String username;

    private String fullName;

    @NotNull(message = "This field is required.")
    @Size(min = 12, max = 12, message = "The size should be 12.")
    private String cnp;

    private Integer age;

    private String otherInformation;

}
