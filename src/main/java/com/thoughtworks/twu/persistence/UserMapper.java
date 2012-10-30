package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Select("SELECT * FROM UserTable where email = #{email}")
    User getUser(String email);

    @Insert("INSERT INTO UserTable (email,name,password,phoneNumber) VALUES(#{email}, #{name}, #{password}, #{phoneNumber})")
    void insertUser(User user);
}
