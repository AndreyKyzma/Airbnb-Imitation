package com.service.impl;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kyza on 30.01.2016.
 */
@Service
public class UserImpl implements UserServices {
   @Autowired
   private UserRepository   userRepository;

    @Override
        public User addUser(User user) {
        User saveUser = userRepository.saveAndFlush(user);
        return saveUser;
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
