package com.thoughtworks.twu.persistence;

import com.thoughtworks.twu.domain.Friendship;
import com.thoughtworks.twu.domain.IntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FriendshipMapperTest extends IntegrationTest {

    @Autowired
    FriendshipMapper friendshipMapper;

    @Test
    public void shouldHaveAFriendEmail() throws Exception {
        Friendship insertedFriend = new Friendship("sajacobs@thoughtworks.com", "raji@gmail.com");
        friendshipMapper.insertFriend(insertedFriend);

        String emailInDB = "raji@gmail.com";
        Friendship friendInDB = friendshipMapper.getFriendByEmail(emailInDB);

        assertThat(friendInDB, equalTo(insertedFriend));
    }

    @Test
     public void shouldGetAFriendFromDBUsingEmail() throws Exception {
        Friendship insertedFriend = new Friendship("sajacobs@thoughtworks.com", "mengqiu@gmail.com");

        String emailInDB = "mengqiu@gmail.com";
        Friendship friendInDB = friendshipMapper.getFriendByEmail(emailInDB);

        assertThat(friendInDB, equalTo(insertedFriend));
    }

}
