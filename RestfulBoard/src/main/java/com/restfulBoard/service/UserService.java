package com.restfulBoard.service;

import com.restfulBoard.dao.UserDao;
import com.restfulBoard.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    //회원가입
    public String signup(User user){
        String userId = userDao.selectUserId(user.getId());
        if(userId == null){
            userDao.insertUser(user);
            return "S";
        }else{
            return "E";
        }
    }
}
