package com.thoughtworks.twu.persistence;


import com.thoughtworks.twu.domain.ConnectionDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

public interface ConnectionMapper {
    @Select("SELECT user_email, connection_email FROM connections Where user_email = #{user_email}")
    ConnectionDetails getConnection(String userEmail);

    @Select("SELECT connection_email FROM connections Where user_email = #{user_email}")
    ArrayList<String> getAllConnections(String userEmail);


    @Insert("INSERT INTO connections (user_email, connection_email) VALUES(#{userEmail}, #{connectionEmail})")
    void insertConnection(ConnectionDetails connectionDetails);


}
