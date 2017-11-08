package com.lease.demo.mapper;

import com.lease.demo.dao.User;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface UserMapper {

    @Insert("INSERT INTO user(user_name,password,user_age,user_sex,address,mobile) VALUES(#{userName},#{passWord},#{userAge},#{userSex},#{address},#{mobile})")
    Boolean addNewUser(User user);
}
