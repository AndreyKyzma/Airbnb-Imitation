package com.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kyza on 30.01.2016.
 */
public class UserList {
    private static final List<User> userList = new ArrayList();

    private UserList(){
    }

    static{
        userList.add(new User("John","Smith","john.smith@abc.com","pass","Sales"));
        userList.add(new User("Laura","Adams","laura.adams@abc.com","pass","IT"));
        userList.add(new User("Peter","Williams","peter.williams@abc.com","pass","HR"));
        userList.add(new User("Joana","Sanders","joana.sanders@abc.com","pass","Marketing"));
        userList.add(new User("John","Drake","john.drake@abc.com","pass","Finance"));
        userList.add(new User("Samuel","Williams","samuel.williams@abc.com","pass","Finance"));
    }

    public static List <User> getInstance(){
        return userList;
    }
}
