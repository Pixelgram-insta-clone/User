package com.cognizant.User.controller;

import com.cognizant.User.model.User;
import com.cognizant.User.model.UserDto;
import com.cognizant.User.service.UserServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    UserServiceImp service;

    @InjectMocks
    UserController controller;

    @Test
    void test_getUser_userFound(){
        User expected = new User(1, "user1", "https://i.guim.co.uk/img/media/66767bbb27ae0e99d0dfb2975ff2a2b3db9e1c93/37_6_1612_967/master/1612.jpg?width=465&quality=45&auto=format&fit=max&dpr=2&s=bc0876e167fca3248a78fcd3f64f4b1d");
        when(service.getUserById(1)).thenReturn(expected);
        assertEquals(expected, controller.getUserById(1));
    }

    @Test
    void test_getUser_noUserFound(){
        when(service.getUserById(-1)).thenReturn(null);
        assertEquals(null, controller.getUserById(-1));
    }

    @Test
    void test_registerNewUser() {
        UserDto dto = new UserDto();
        dto.setId(1);
        dto.setUsername("username1");
        User expected = new User(1, "username1", null);
        when(service.saveUser(expected)).thenReturn(expected);
        assertEquals(expected, controller.createUser(dto));
    }


}
