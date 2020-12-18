package com.unibuc.lab11.service;

import com.unibuc.lab11.domain.User;
import com.unibuc.lab11.domain.UserDetails;
import com.unibuc.lab11.domain.UserType;
import com.unibuc.lab11.dto.UserDto;
import com.unibuc.lab11.mapper.UserMapper;
import com.unibuc.lab11.repository.UserRepository;
import com.unibuc.lab11.util.UserDtoUtil;
import com.unibuc.lab11.util.UserUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        // Arrange
        UserDto userDto = UserDtoUtil.aUserDto("Silvia");
        User user = UserUtil.anUser("Silvia");
        User savedUser = UserUtil.anUser(1L);

        when(userMapper.mapToEntity(userDto)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(savedUser);
        when(userMapper.mapToDto(savedUser)).thenReturn(userDto);

        // Act
        UserDto result = userService.create(userDto, UserType.STUDENT);

        // Assert
        assertThat(result).isNotNull();

        verify(userMapper, times(1)).mapToEntity(userDto);
        verify(userMapper, times(1)).mapToDto(savedUser);
        verify(userRepository, times(1)).save(user);

        verifyNoMoreInteractions(userMapper, userRepository);
    }
}
