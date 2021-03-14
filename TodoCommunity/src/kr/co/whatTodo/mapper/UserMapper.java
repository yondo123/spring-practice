package kr.co.whatTodo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.whatTodo.beans.UserInfoBean;

public interface UserMapper {
	// ID 중복검사
	@Select("SELECT  USER_NAME\n" + "FROM USER_TABLE \n" + "WHERE USER_ID = #{USER_ID}")
	String userIdExistFlag(String user_id);

	// 계정 생성
	@Insert("INSERT INTO USER_TABLE (USER_INDEX, USER_NAME, USER_ID, USER_PW) "
			+ "VALUES (USER_SEQ.nextval, #{userName}, #{userId}, #{userPw})")
	void addUser(UserInfoBean userInfoBean);
}