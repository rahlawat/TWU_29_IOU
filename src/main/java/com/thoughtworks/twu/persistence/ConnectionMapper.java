package com.thoughtworks.twu.persistence;


import com.thoughtworks.twu.domain.ConnectionDetails;
import org.apache.ibatis.annotations.Insert;

public interface ConnectionMapper {

    @Insert("INSERT INTO connections (user_email, connection_email) VALUES(#{userEmail}, #{connectionEmail})")
    void insertConnection(ConnectionDetails connectionDetails);


}
