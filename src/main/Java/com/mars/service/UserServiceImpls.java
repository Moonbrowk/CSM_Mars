package com.mars.service;

import com.mars.dao.RoleDao;
import com.mars.dao.UserDao;
import com.mars.model.Role;
import com.mars.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpls implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleDao.getOne(1L));

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(roleSet);

        userDao.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }
}
