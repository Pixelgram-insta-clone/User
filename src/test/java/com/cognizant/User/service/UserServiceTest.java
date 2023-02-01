package com.cognizant.User.service;

import com.cognizant.User.model.User;
import com.cognizant.User.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userService;

    @Test
    void getUser_userFound(){
        User expected = new User(1, "user1", "https://i.guim.co.uk/img/media/66767bbb27ae0e99d0dfb2975ff2a2b3db9e1c93/37_6_1612_967/master/1612.jpg?width=465&quality=45&auto=format&fit=max&dpr=2&s=bc0876e167fca3248a78fcd3f64f4b1d");
        when(userRepository.findById(1)).thenReturn(Optional.of(expected));
        assertEquals(expected, userService.getUserById(1));
    }

    @Test
    void getUser_noUser(){
        when(userRepository.findById(-1)).thenReturn(Optional.empty());
        assertEquals(null, userService.getUserById(-1));
    }

    @Test
    void createUser_positive() {
        User dto = new User();
        dto.setId(1);
        dto.setUsername("username1");
        User user = new User(1, "username1", null);

        when(userRepository.save(dto)).thenReturn(user);

        User actual = userService.saveUser(dto);

        Assertions.assertEquals(user, actual);

    }
}
