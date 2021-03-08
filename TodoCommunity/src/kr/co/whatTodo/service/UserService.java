package kr.co.whatTodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.whatTodo.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public String userIdEx(String USER_ID) {
		String userName = userDao.checkUserId(USER_ID);
		if(userName == null) {
			return "1";
		}else {
			return "0";
		}
	}
}
