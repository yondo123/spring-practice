package kr.co.whatTodo.service;


import javax.annotation.Resource;

import org.apache.catalina.Session;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Resource(name = "loginUserInfoBean")
	@Lazy
	private UserInfoBean loginUserInfo;
	
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
	
	//로그인
	public void login(UserInfoBean userInfoBean) {
		UserInfoBean userInfo = userDao.login(userInfoBean);
		if(userInfo != null) {
			loginUserInfo.setUserId(userInfoBean.getUserId());
			loginUserInfo.setUserName(userInfoBean.getUserName());
			loginUserInfo.setIsLogin(true);
		}
			
	}
}
