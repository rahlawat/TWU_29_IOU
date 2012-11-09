package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Friendship;
import com.thoughtworks.twu.domain.IntegrationTest;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FriendshipMapperTest extends IntegrationTest {

    @Autowired
    FriendshipMapper friendshipMapper;

    @Test
    @Ignore
    public void shouldHaveAFriendEmail() throws Exception {
        Friendship insertedFriend = new Friendship("sajacobs@thoughtworks.com", "raji@gmail.com");
        friendshipMapper.insertFriend(insertedFriend);

        String emailInDB = "raji@gmail.com";
        Friendship friendInDB = friendshipMapper.getFriendByEmail(emailInDB);

        assertThat(friendInDB, equalTo(insertedFriend));
    }

    @Test
    @Ignore //TODO: These are using a mapper that is using the wrong table, be sure to fix!!!!
     public void shouldGetAFriendFromDBUsingEmail() throws Exception {
        Friendship insertedFriend = new Friendship("sajacobs@thoughtworks.com", "mengqiu@gmail.com");

        String emailInDB = "mengqiu@gmail.com";
        Friendship friendInDB = friendshipMapper.getFriendByEmail(emailInDB);

        assertThat(friendInDB, equalTo(insertedFriend));
    }

}
