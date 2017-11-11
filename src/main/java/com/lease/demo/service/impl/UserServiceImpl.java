package com.lease.demo.service.impl;

import com.lease.demo.dao.User;
import com.lease.demo.mapper.UserMapper;
import com.lease.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/30.
 */
@SuppressWarnings("all")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Boolean addNewUser(User user) {
        return userMapper.addNewUser(user);
    }
}
