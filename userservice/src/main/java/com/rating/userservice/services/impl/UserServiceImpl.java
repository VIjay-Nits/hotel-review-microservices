package com.rating.userservice.services.impl;

import com.rating.userservice.entities.User;
import com.rating.userservice.exceptions.ResourceNotFoundException;
import com.rating.userservice.repositories.UserRepository;
import com.rating.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User createUser(User user) {

        String randomId = UUID.randomUUID().toString();
        System.out.println(user+"service");
        user.setUserId(randomId);
        return userRepository.save(user);

    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User is not Present" + userId));
    }
}
