package com.restfulBoard.service;

import com.restfulBoard.dao.UserDao;
import com.restfulBoard.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userId = userDao.selectUserId(user.getId());
        String cryptoPw = passwordEncoder.encode(user.getPassword());
        if(userId == null){
            user.setPassword(cryptoPw);
            System.out.println(user.getPassword());
            userDao.insertUser(user);
            loginUser.setId(user.getId());
            loginUser.setPassword(user.getPassword());
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
