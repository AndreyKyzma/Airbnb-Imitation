package com.model;

import org.hibernate.annotations.*;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.concurrent.atomic.AtomicLong;


/**
 * Created by Kyza on 21.01.2016.
 */
@Entity

public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;


    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_type")
    private String usertype;

    private static final AtomicLong counter = new AtomicLong(100);

    public User(String name, String surname, String city, String email, String password, String usertype, long id) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.id = id;
    }

    public User(String name, String surname, String email, String password, String usertype) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.usertype = usertype;
        this.id = counter.incrementAndGet();
    }

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
