package kr.co.whatTodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.JdbcType;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.beans.CategoryBean;

public interface BoardMapper {
	// 전체 갯수
	@Select("SELECT COUNT(*) totalCount " + "FROM CONTENT_TABLE ct, USER_TABLE ut "
			+ "WHERE ct.CONTENT_BOARD_INDEX = #{boardIndex} " + "AND ct.CONTENT_WRITER_INDEX = ut.USER_INDEX "
			+ "ORDER BY ct.CONTENT_INDEX")
	int selectContentTotalCount(int boardIndex);
	
	// 임시 파일 조회
	@Select("SELECT IMAGE_FILE FROM DUMP_IMAGE_TABLE WHERE IMAGE_FILE LIKE '%'||#{fileName}||'%'")
	String selectUploadFilePath(@Param("fileName") String fileName);

	// 임시 이미지 등록
	@Insert("INSERT INTO DUMP_IMAGE_TABLE(" + "IMAGE_INDEX, IMAGE_FILE, UPLOAD_DATE, UPLOADER_INDEX) "
			+ "VALUES(DUMP_IMAGE_SEQ.NEXTVAL, #{imageFileName}, sysdate, #{uploaderIndex})")
	void insertDumpImage(@Param("uploaderIndex") int uploaderIndex, @Param("imageFileName") String imageFileName);

	// 게시글 등록
	@Insert("INSERT INTO CONTENT_TABLE("
			+ "CONTENT_INDEX, CONTENT_SUBJECT, CONTENT_FILE, CONTENT_WRITER_INDEX, CONTENT_CONTEXT, CONTENT_BOARD_INDEX,"
			+ "CONTENT_DATE, CONTENT_CATE_INDEX)"
			+ "VALUES (CONTENT_SEQ.NEXTVAL, #{contentSubject}, #{file, jdbcType=VARCHAR},"
			+ "#{writerIndex}, #{contentContext, jdbcType=CLOB} ,#{boardIndex}, sysdate, #{cateIndex})")
	void insertContentInfo(BoardListBean boardListBean);

	// 게시글 조회
	@Select("SELECT ct.CONTENT_SUBJECT AS contentSubject, ut.USER_ID AS writerId, ct.CONTENT_CATE_INDEX AS cateIndex, "
			+ "		to_char(ct.CONTENT_DATE, 'YYYYMMDD') AS writeDate " + "FROM CONTENT_TABLE ct, USER_TABLE ut "
			+ "WHERE ct.CONTENT_BOARD_INDEX = #{boardIndex} " + "AND ct.CONTENT_WRITER_INDEX = ut.USER_INDEX "
			+ "ORDER BY ct.CONTENT_INDEX")
	List<BoardListBean> selectContentList(int boardIndex, RowBounds rowBounds);

	// 카테고리 목록 조회
	@Select("SELECT BOARD_CATE_INDEX AS cateIndex, BOARD_CATE_NAME AS cateName FROM BOARD_CATE_TABLE bct")
	List<CategoryBean> selectCategoryList();
}
