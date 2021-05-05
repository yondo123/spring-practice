package kr.co.whatTodo.mapper;

import javax.validation.constraints.NotBlank;

import org.apache.ibatis.annotations.Insert;
import org.springframework.web.multipart.MultipartFile;

import kr.co.whatTodo.beans.BoardListBean;

public interface BoardMapper {
	@Insert("INSERT INTO CONTENT_TABLE("
			+ "CONTENT_INDEX, CONTENT_SUBJECT, CONTENT_TEXT, CONTENT_FILE, CONTENT_WRITER_INDEX, CONTENT_BOARD_INDEX,"
			+ "CONTENT_DATE, CONTENT_CATE_INDEX)"
			+ "VALUES (CONTENT_SEQ.NEXTVAL, #{contentSubject}, #{contentText}, #{file, jdbcType=VARCHAR},"
			+ "#{writerIndex}, #{boardIndex}, sysdate, #{cateIndex})")
	void insertContentInfo(BoardListBean boardListBean);
}

