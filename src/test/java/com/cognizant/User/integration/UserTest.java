package com.cognizant.User.integration;

import com.cognizant.User.controller.UserController;
import com.cognizant.User.model.User;
import com.cognizant.User.model.UserDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserTest {

    List<User> users = new ArrayList<User>();

    @Autowired
    private UserController controller;

    @BeforeAll
    void init() {
        users.add(new User(1, "user1", "https://i.guim.co.uk/img/media/66767bbb27ae0e99d0dfb2975ff2a2b3db9e1c93/37_6_1612_967/master/1612.jpg?width=465&quality=45&auto=format&fit=max&dpr=2&s=bc0876e167fca3248a78fcd3f64f4b1d"));
        users.add(new User(2, "username2", "image2.jpg"));
        users.add(new User(3, "username3", "image3.jpg"));
        users.add(new User(4, "username4", "image4.jpg"));
        users.add(new User(5, "username5", "image5.jpg"));
        users.add(new User(6, "username6", "image6.jpg"));
    }

    @Test
    void integration_getUser_userFound(){
        User expected = new User(1, "user1", "https://i.guim.co.uk/img/media/66767bbb27ae0e99d0dfb2975ff2a2b3db9e1c93/37_6_1612_967/master/1612.jpg?width=465&quality=45&auto=format&fit=max&dpr=2&s=bc0876e167fca3248a78fcd3f64f4b1d");
        assertEquals(expected, controller.getUserById(1));
    }

    @Test
    void integration_getUser_noUser(){
        assertNull(controller.getUserById(-1));

    }

    @Test
    void integration_saveUser() {
        UserDto dto = new UserDto();
        dto.setId(100);
        dto.setUsername("user100");
        User expected = new User(100, "user100", null);
        assertEquals(expected, controller.createUser(dto));
    }
}
