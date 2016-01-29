package com.service.impl;

import com.repository.UserRepository;
import com.model.User;
import com.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Kyza on 24.01.2016.
 */
@Service
public class UserImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public User addUser(User user) {
//        User saveUser = userRepository.saveAndFlush(user);
//        return saveUser;
//    }

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

    public  List<User> getInstance(){
        return userList;
    }

    List<User> userList = new ArrayList<>();


    public List<User> searchUserByName(String name) {
        Comparator<User> groupByComparator = Comparator.comparing(User::getName)
                .thenComparing(User::getSurname);
        List<User> result = userList
                .stream()
                .filter(e -> e.getName()
                        .equalsIgnoreCase(name) || e.getSurname()
                        .equalsIgnoreCase(name))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }
    public User getUser(long id) throws Exception {
        Optional<User> match
                = userList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The User id " + id + " not found");
        }
    }
    @Override
    public  User addUser(User user) {
        User saveUser = userRepository.saveAndFlush(user);
        userList.add(user);
        return saveUser;
    }

    public boolean updateUser(User user) {
        int matchIdx = 0;
        Optional<User> match = userList.stream()
                .filter(c -> c.getId() == user.getId())
                .findFirst();
        if (match.isPresent()) {
            matchIdx = userList.indexOf(match.get());
            userList.set(matchIdx, user);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUser(long id) {
        Predicate<User> employee = e -> e.getId() == id;
        if (userList.removeIf(employee)) {
            return true;
        } else {
            return false;
        }
    }
}
