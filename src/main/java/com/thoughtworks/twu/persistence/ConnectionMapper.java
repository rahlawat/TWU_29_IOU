package com.thoughtworks.twu.persistence;


import com.thoughtworks.twu.domain.ConnectionDetails;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ConnectionMapper {
    @Select("SELECT connection_email FROM connections Where user_email = #{userEmail}")
    List<String> getAllConnections(String userEmail);


    @Insert("INSERT INTO connections (user_email, connection_email) VALUES(#{userEmail}, #{connectionEmail})")
    void insertConnection(ConnectionDetails connectionDetails);


}
