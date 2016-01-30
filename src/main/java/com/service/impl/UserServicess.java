package com.service.impl;

import com.model.User;
import com.model.UserList;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Kyza on 30.01.2016.
 */
public class UserServicess {
    List<User> userList = UserList.getInstance();

    public List<User> getAllUser() {
        return userList;
    }

    public List<User> searchUserByName(String userName) {
        Comparator<User> groupByComparator = Comparator.comparing(User::getName)
                .thenComparing(User::getSurname);
        List<User> result = userList
                .stream()
                .filter(e -> e.getName()
                        .equalsIgnoreCase(userName) || e.getSurname()
                        .equalsIgnoreCase(userName))
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

    public long addUser(User user) {
        userList.add(user);
        return user.getId();
    }

    public boolean updateUser(User customer) {
        int matchIdx = 0;
        Optional<User> match = userList.stream()
                .filter(c -> c.getId() == customer.getId())
                .findFirst();
        if (match.isPresent()) {
            matchIdx = userList.indexOf(match.get());
            userList.set(matchIdx, customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteUser(long id) {
        Predicate<User> user = e -> e.getId() == id;
        if (userList.removeIf(user)) {
            return true;
        } else {
            return false;
        }
    }
}