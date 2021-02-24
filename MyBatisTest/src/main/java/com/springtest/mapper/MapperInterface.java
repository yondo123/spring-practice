package com.springtest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.springtest.beans.UserVO;

public interface MapperInterface {
	/*
	 * @Results({ @Result(column = "name", property = "name"), @Result(column =
	 * "sex", property = "sex"),
	 * 
	 * @Result(column = "hobby", property = "hobby") })
	 */
	@Select("SELECT NAME, SEX, HOBBY FROM USER_TABLE")
	List<UserVO> selectData();

	@Insert("INSERT INTO USER_TABLE (NAME, SEX, HOBBY) VALUES(#{name}, #{sex}, #{hobby})")
	void insertData(UserVO bean);
}
