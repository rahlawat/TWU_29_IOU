package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM UserTable where email = #{email}")
    User getUserByEmail(String email);

    @Insert("INSERT INTO UserTable (email,username,password,phoneNumber) " +
            "VALUES (#{email}, #{username}, #{password}, #{phoneNumber})")
    void insertUser(User user);
}
