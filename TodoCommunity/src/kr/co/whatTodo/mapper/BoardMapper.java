package kr.co.whatTodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.co.whatTodo.beans.BoardListBean;

public interface BoardMapper {
	@Insert("INSERT INTO CONTENT_TABLE("
			+ "CONTENT_INDEX, CONTENT_SUBJECT, CONTENT_TEXT, CONTENT_FILE, CONTENT_WRITER_INDEX, CONTENT_BOARD_INDEX,"
			+ "CONTENT_DATE, CONTENT_CATE_INDEX)"
			+ "VALUES (CONTENT_SEQ.NEXTVAL, #{contentSubject}, #{contentText}, #{file, jdbcType=VARCHAR},"
			+ "#{writerIndex}, #{boardIndex}, sysdate, #{cateIndex})")
	void insertContentInfo(BoardListBean boardListBean);
	
	@Select("SELECT ct.CONTENT_SUBJECT AS contentSubject, ut.USER_ID AS writerId, "
			+ "		to_char(ct.CONTENT_DATE, 'YYYYMMDD') AS writeDate "
			+ "FROM CONTENT_TABLE ct, USER_TABLE ut "
			+ "WHERE ct.CONTENT_BOARD_INDEX = #{boardIndex} "
			+ "AND ct.CONTENT_WRITER_INDEX = ut.USER_INDEX "
			+ "ORDER BY ct.CONTENT_INDEX")
	List<BoardListBean> selectContentList(int boardIndex);
}
