package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.LoginUser;
import com.thoughtworks.twu.domain.User;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {
    @Select("select email, username, password, phoneNumber from UserTable where email = #{email}")
    public LoginUser getUser(String email);



}
