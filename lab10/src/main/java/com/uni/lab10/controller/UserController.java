package com.uni.lab10.controller;

import com.uni.lab10.domain.UserType;
import com.uni.lab10.dto.UserDto;
import com.uni.lab10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/student")
    public ResponseEntity<UserDto> createStudent(@RequestBody @Valid UserDto userDto) {
        UserDto savedUser = userService.create(userDto, UserType.STUDENT);

        return ResponseEntity
                .ok()
                .body(savedUser);
    }

    @PostMapping("/professor")
    public ResponseEntity<UserDto> createProfessor(@RequestBody @Valid UserDto userDto) {
        UserDto savedUser = userService.create(userDto, UserType.PROFESSOR);

        return ResponseEntity
                .ok()
                .body(savedUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDto> get(@PathVariable("username") String username) {
       UserDto userDto = userService.getOne(username);

        return ResponseEntity
                .ok()
                .body(userDto);
    }

    @GetMapping("/randomUsers")
    public ResponseEntity<Boolean> generateTwoRandomUsers() {
        return ResponseEntity
                .ok()
                .body(userService.generateTwoRandomUsers());
    }
}
