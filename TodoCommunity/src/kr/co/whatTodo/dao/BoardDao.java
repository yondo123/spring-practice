package kr.co.whatTodo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.beans.CategoryBean;
import kr.co.whatTodo.beans.PostBean;
import kr.co.whatTodo.mapper.BoardMapper;

@Repository
public class BoardDao {
	
	@Autowired
	private BoardMapper boardMapper;
	
	//게시글 개수 조회
	public int selectContentTotalCount(int boardIndex) {
		return boardMapper.selectContentTotalCount(boardIndex);
	}
	
	//게시글 작성
	public void insertContentInfo(BoardListBean boardListBean) {
		boardMapper.insertContentInfo(boardListBean);
	}
	
	//게시글 수정
	public void updateContentInfo(BoardListBean boardListBean) {
		boardMapper.updateContentInfo(boardListBean);
	}
	
	//임시 이미지 저장
	public void insertDumpImage(int uploaderIndex, String imageFileName) {
		boardMapper.insertDumpImage(uploaderIndex, imageFileName);
	}
	
	//게시물 조회
	public List<BoardListBean> selectContentList(int boardIndex, RowBounds rowBounds) {
		return boardMapper.selectContentList(boardIndex, rowBounds);
	}
	
	//카테고리 리스트 조회
	public List<CategoryBean> selectCategoryList(){
		return boardMapper.selectCategoryList();
	}
	
	//임시 이미지 경로 조회
	public String selectUploadFilePath(String fileName) {
		return boardMapper.selectUploadFilePath(fileName);
	}
	
	//게시글 상세조회
	public PostBean selectPostInfo(int contentIndex) {
		return boardMapper.selectPostInfo(contentIndex);
	}
	
}
