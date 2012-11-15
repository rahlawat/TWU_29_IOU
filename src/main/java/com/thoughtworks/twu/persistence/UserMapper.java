package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.DebtorDetails;
import com.thoughtworks.twu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface UserMapper {
    @Select("SELECT * FROM UserTable where email = #{email}")
    User getUserByEmail(String email);

    @Insert("INSERT INTO UserTable (email,username,password,phoneNumber) " +
            "VALUES (#{email}, #{username}, #{password}, #{phoneNumber})")
    void insertUser(User user);

    @Select("Select debtor,amount from peopleWhoOweMe where user_email = #{email}")
    ArrayList<DebtorDetails> getPeopleWhoOweMe(String userEmail);


}
