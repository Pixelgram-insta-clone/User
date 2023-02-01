package com.cognizant.User.service;

import com.cognizant.User.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User getUserById(int id);
    public User saveUser(User user);
}
