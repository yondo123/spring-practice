package kr.co.whatTodo.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	@Select("SELECT  USER_NAME\n"
			+ "FROM USER_TABLE \n"
			+ "WHERE USER_ID = #{USER_ID}")
	String userIdExistFlag(String user_id);
}
