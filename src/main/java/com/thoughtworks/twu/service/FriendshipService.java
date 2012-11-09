package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.Friendship;
import com.thoughtworks.twu.persistence.FriendshipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService {
    private FriendshipMapper friendshipMapper;

    @Autowired
    public FriendshipService(FriendshipMapper friendshipMapper) {
        this.friendshipMapper = friendshipMapper;
    }

//    public List<String> getAllFriendsForOneUserEmail(String userEmail) {
//        return friendshipMapper.getAllFriendsForOneUserEmail(userEmail);
//    }
}
