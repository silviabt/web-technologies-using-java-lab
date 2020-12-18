package com.unibuc.lab11.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unibuc.lab11.domain.UserType;
import com.unibuc.lab11.dto.UserDto;
import com.unibuc.lab11.exception.AnotherEntityNotFoundException;
import com.unibuc.lab11.service.UserService;
import com.unibuc.lab11.util.UserDtoUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testCreateStudent() throws Exception {
        // Arrange
        UserDto userDto = UserDtoUtil.aUserDto("Silvia");

        when(userService.create(any(), any())).thenReturn(userDto);

        // Act
        MvcResult result = mockMvc.perform(post("/users/student")
                .content(objectMapper.writeValueAsString(userDto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(userDto));
    }

    @Test
    public void testGetOne() throws Exception {
        // Arrange
        String username = "silvia";
        UserDto userDto = UserDtoUtil.aUserDto(username);
        when(userService.getOne(username)).thenReturn(userDto);

        // Act
        MvcResult result = mockMvc.perform(get("/users/" + username))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        assertThat(result.getResponse().getContentAsString()).isEqualTo(objectMapper.writeValueAsString(userDto));
    }

    @Test
    public void testGetOneCascadesException() throws Exception {
        // Arrange
        String username = "silvia";
        when(userService.getOne(username))
                .thenThrow(new AnotherEntityNotFoundException("silvia"));

        // Act
        AnotherEntityNotFoundException exception = assertThrows(
                AnotherEntityNotFoundException.class,
                () -> userController.get(username),
                "Expected get() to throw AnotherEntityNotFoundException, but it didn't"
        );

        // Assert
        assertTrue(exception.getMessage().contains(username));
    }
}
