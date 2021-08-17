package com.restfulBoard.dao;

import com.restfulBoard.dto.User;
import com.restfulBoard.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    //id check
    public String selectUserId(String userId) {
        return userMapper.userId(userId);
    }

    //sign
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    //user check
    public int selectUserCnt(User user) {
       return userMapper.selectUser(user);
    }
}
