package com.restfulBoard.mapper;

import com.restfulBoard.dto.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT USER_ID FROM USER_TBL WHERE USER_ID = #{userId}")
    String userId(String userId);

    @Insert("INSERT INTO USER_TBL(USER_ID, USER_PASSWORD) " +
            "VALUES (#{id}, #{password})")
    void insertUser(User user);
}
