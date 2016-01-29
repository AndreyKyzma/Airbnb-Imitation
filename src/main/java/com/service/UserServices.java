package com.service;

import com.model.User;

import java.util.List;

/**
 * Created by Kyza on 23.01.2016.
 */
public interface UserServices {
    long addUser(User user);
    boolean deleteUser(long id);
    User editUser(User user);
    List<User> getAllUser();
}
