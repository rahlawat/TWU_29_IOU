package com.thoughtworks.twu.persistence;


import com.thoughtworks.twu.domain.Friendship;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

//job: understands the database operations of the friends
public interface FriendshipMapper {
    @Select("SELECT userEmail,friendEmail FROM friendshipTable Where friendEmail = #{friendEmail}")
    Friendship getFriendByEmail(String friendEmail);

    @Insert("INSERT INTO friendshipTable (userEmail, friendEmail) VALUES(#{userEmail}, #{friendEmail})")
    void insertFriend(Friendship FriendshipTable);
}
