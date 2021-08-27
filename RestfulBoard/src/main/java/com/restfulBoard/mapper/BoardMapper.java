package com.restfulBoard.mapper;

import com.restfulBoard.dto.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {
    //게시글 삽입
    @Insert("INSERT INTO BOARD_TBL(USER_ID, POST_CONTEXT, POST_DATE, POST_TITLE)" +
            "VALUES (#{writer}, #{context}, DATE_FORMAT(NOW(), '%Y%m%d'), #{title})")
    void insertPost(Board board);

    //게시글 전체갯수
    @Select("SELECT COUNT(*) totalCount FROM BOARD_TBL")
    int getBoardSize();

    //게시글 목록조회
    @Select("select R1.* FROM(" +
            "SELECT USER_ID AS writer, POST_CONTEXT AS context, POST_DATE AS writeDate, POST_TITLE AS title " +
            "FROM BOARD_TBL order by POST_UUID ASC" +
            ") R1 " +
            "LIMIT 10 OFFSET #{reqPage}")
    List<Board> getBoardList(int reqPage);
}
