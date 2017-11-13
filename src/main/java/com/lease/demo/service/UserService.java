package com.lease.demo.service;

import com.lease.demo.dao.User;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface UserService {

    Boolean addNewUser(User user);

    User getUserByUserNameAndPassword(User user);

    String getUserAddrByUserId(Object userId);
}
