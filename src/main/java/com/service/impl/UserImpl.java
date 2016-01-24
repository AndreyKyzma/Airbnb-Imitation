package com.service.impl;
import com.repository.UserRepo;
import com.model.User;
import com.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kyza on 24.01.2016.
 */
@Service
public class UserImpl implements UserServices {

    @Autowired
    UserRepo userRepo;

    @Override
    public User addUser(User user) {
        User saveUser = userRepo.saveAndFlush(user);
        return saveUser;
    }

    @Override
    public void delete(long id) {
        userRepo.delete(id);
    }



    @Override
    public User editUser(User user) {
        return userRepo.saveAndFlush(user);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
