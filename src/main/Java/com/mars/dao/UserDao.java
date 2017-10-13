package com.mars.dao;

import com.mars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
    String findByUserName(String userName);
}