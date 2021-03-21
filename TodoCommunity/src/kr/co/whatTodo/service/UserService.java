package kr.co.whatTodo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	//ID 존재 확인 
	public Boolean userIdEx(String USER_ID) {
		String userName = userDao.checkUserId(USER_ID);
		if(userName == null) {
			return true;
		}else {
			return false;
		}
	}
	
	//회원가입
	public void addUser(UserInfoBean userInfoBean) {
		userDao.addUser(userInfoBean);
	}
}
