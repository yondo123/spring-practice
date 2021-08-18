package com.restfulBoard.mapper;

import com.restfulBoard.dto.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface BoardMapper {
    @Insert("INSERT INTO BOARD_TBL(USER_ID, POST_CONTEXT, POST_DATE, POST_TITLE)" +
            "VALUES (#{writer}, #{context}, DATE_FORMAT(NOW(), '%Y%m%d'), #{title})")
    void insertPost(Board board);

}
