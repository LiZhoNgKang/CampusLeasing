package com.lease.demo.mapper;

import com.lease.demo.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/10/30.
 */
public interface UserMapper {

    @Insert("INSERT INTO user(user_name,password,user_age,user_sex,address,mobile,rank) VALUES(#{userName},#{password},#{userAge},#{userSex},#{address},#{mobile},0)")
    Boolean addNewUser(User user);

    @Select("select * from user where user_name=#{userName} AND password=#{password}")
    User getUserByUserNameAndPassword(User user);

    @Select("select address from user where user_id=#{uderId}")
    String getUserAddrByUserId(String userId);
}
