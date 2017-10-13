package com.mars.service;

import com.mars.model.User;

public interface UserService {

    void save(User user);
    String findByUserName(String username);
}
