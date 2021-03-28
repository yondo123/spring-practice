package kr.co.whatTodo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.mapper.UserMapper;

@Repository
public class UserDao {
	@Autowired
	private UserMapper userMapper;

	// id 중복검사
	public String checkUserId(String USER_ID) {
		return userMapper.userIdExistFlag(USER_ID);
	}

	// 회원가입 처리
	public void addUser(UserInfoBean userInfoBean) {
		userMapper.addUser(userInfoBean);
	}

	// 로그인
	public UserInfoBean login(UserInfoBean userInfoBean) {
		return userMapper.login(userInfoBean);
	}
}
