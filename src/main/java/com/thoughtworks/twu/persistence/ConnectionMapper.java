package com.thoughtworks.twu.persistence;


import com.thoughtworks.twu.domain.ConnectionDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
public interface ConnectionMapper {


    @Select("SELECT userEmail, connectionEmail FROM connections Where userEmail = #{userEmail} AND connectionEmail = #{connectionEmail}")
    ConnectionDetails getConnection(ConnectionDetails connectionDetails);

    @Select("SELECT connectionEmail FROM connections Where userEmail = #{userEmail}")
    ArrayList<String> getAllConnections(String userEmail);

    @Insert("INSERT INTO connections (userEmail, connectionEmail) VALUES(#{userEmail}, #{connectionEmail})")
    void insertConnection(ConnectionDetails connectionDetails);


}
