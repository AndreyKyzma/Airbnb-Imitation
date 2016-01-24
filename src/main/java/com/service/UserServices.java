package com.service;

import com.model.User;

import java.util.List;

/**
 * Created by Kyza on 23.01.2016.
 */
public interface UserServices {
    User addUser(User user);
    void delete(long id);
    User editUser(User user);
    List<User>getAll();
}
