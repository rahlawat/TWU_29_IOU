package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConnectionMapperTest extends IntegrationTest {

    @Autowired
    ConnectionMapper connectionMapper;

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
