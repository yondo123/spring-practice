package com.restfulBoard.service;

import com.restfulBoard.dao.UserDao;
import com.restfulBoard.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    @Resource(name = "loginUser")
    @Lazy
    private User loginUser;
    //회원가입
    public String signup(User user){
        String userId = userDao.selectUserId(user.getId());
        if(userId == null){
            userDao.insertUser(user);
            return "S";
        }else{
            int userCount = userDao.selectUserCnt(user);
            if(userCount > 0){
                loginUser.setId(user.getId());
                loginUser.setPassword(user.getPassword());
                return "Y";
            }else{
                return "E";
            }
        }
    }
}
