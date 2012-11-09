package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Friendship;
import com.thoughtworks.twu.domain.IntegrationTest;
import com.thoughtworks.twu.persistence.FriendshipMapper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FriendshipServiceTest {

    private FriendshipService friendshipService;

    @Autowired
    private FriendshipMapper friendshipMapper;
    @Before
            public void setUp()
    {
    friendshipService = new FriendshipService(friendshipMapper);

    }

    @Test
    @Ignore
    public void shouldReturnAllFriendsForOneUserEmail() throws Exception {
        String userEmail = "sajacobs@thoughtworks.com";

        List<String> expectedFriends = new ArrayList<String>();
        expectedFriends.add("mengqiu@gmail.com");
        expectedFriends.add("faris@gmail.com");

        List<String> actualFriendsFromDB = friendshipService.getAllFriendsForOneUserEmail(userEmail);
        System.out.println(actualFriendsFromDB);
        assertThat(actualFriendsFromDB, is(expectedFriends));
    }
}
