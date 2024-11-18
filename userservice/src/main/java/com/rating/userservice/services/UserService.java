package com.rating.userservice.services;

import com.rating.userservice.entities.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getAllUser();

    User getUserById(String userId);

    //delete and update pending

}
