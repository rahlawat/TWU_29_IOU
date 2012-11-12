package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.ConnectionDetails;
import com.thoughtworks.twu.domain.IntegrationTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConnectionMapperTest extends IntegrationTest {

    @Autowired
    ConnectionMapper connectionMapper;

    @Test
    @Ignore
    public void shouldGetConnectionFromDB() {
        ConnectionDetails connection = new ConnectionDetails("yue@thoughtworks.com", "faris@thoughtworks.com");
        connectionMapper.insertConnection(connection);

        String userEmail = "yue@thoughtworks.com";
        ConnectionDetails connectionInDB = connectionMapper.getConnection(userEmail);

        assertThat(connectionInDB, equalTo(connection));
    }

    @Test
    public void shouldReturnAllConnectionsForOneUser() throws Exception {
        String userEmail = "yding@thoughtworks.com";

        ArrayList<String> expectedFriends = new ArrayList<String>();
        expectedFriends.add("faris@thoughtworks.com");
        expectedFriends.add("renu@thoughtworks.com");
        expectedFriends.add("sam@thoughtworks.com");

        ArrayList<String> actualFriendsFromDB = connectionMapper.getAllConnections(userEmail);

        assertThat(actualFriendsFromDB, is(expectedFriends));
    }

}
