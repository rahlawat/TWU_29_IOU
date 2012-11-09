package com.thoughtworks.twu.persistence;


import com.thoughtworks.twu.domain.Friendship;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

//job: understands the database operations of the friends
public interface FriendshipMapper {

    @Select("SELECT userEmail,friendEmail FROM friendshipTable Where friendEmail = #{friendEmail}")
    Friendship getFriendByEmail(String friendEmail);

    @Select("SELECT friendEmail FROM friendshipTable Where userEmail = #{userEmail}")
    List<String> getAllFriendsForOneUserEmail(String userEmail);

    @Insert("INSERT INTO friendshipTable (userEmail, friendEmail) VALUES(#{userEmail}, #{friendEmail})")
    void insertFriend(Friendship FriendshipTable);
}
