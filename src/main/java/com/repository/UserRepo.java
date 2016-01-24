package com.repository;

import com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Kyza on 22.01.2016.
 */
public interface UserRepo extends JpaRepository<User, Long> {
}