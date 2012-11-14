package com.thoughtworks.twu.service;

import com.thoughtworks.twu.domain.OweMe;
import com.thoughtworks.twu.domain.User;
import com.thoughtworks.twu.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    private UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserByEmail(String name){
        return userMapper.getUserByEmail(name);
    }
    public void insertUser(User user){
        userMapper.insertUser(user);
    }

    public List<OweMe> getPeopleWhoOweMe() {
        List<OweMe> oweMeList= new ArrayList<OweMe>();
        oweMeList.add(new OweMe("Renu",100));
        return oweMeList;
    }
}
