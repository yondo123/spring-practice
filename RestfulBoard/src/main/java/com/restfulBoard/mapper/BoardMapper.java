package com.restfulBoard.mapper;

import com.restfulBoard.dto.Board;
import org.apache.ibatis.annotations.Insert;

public interface BoardMapper {
    @Insert("INSERT INTO BOARD_TBL(POST_UUID, USER_ID, POST_CONTEXT, POST_DATE, POST_TITLE)" +
            "VALUES ((SELECT NEXTSEQ('BOARD')), #{writer}, #{context}, DATE_FORMAT(NOW(), '%Y%m%d'), #{title})")
    void insertPost(Board board);

}
