package kr.co.whatTodo.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.beans.CategoryBean;
import kr.co.whatTodo.mapper.BoardMapper;

@Repository
public class BoardDao {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public int selectContentTotalCount(int boardIndex) {
		return boardMapper.selectContentTotalCount(boardIndex);
	}
	
	public void insertContentInfo(BoardListBean boardListBean) {
		boardMapper.insertContentInfo(boardListBean);
	}
	
	public void insertDumpImage(int uploaderIndex, String imageFileName) {
		boardMapper.insertDumpImage(uploaderIndex, imageFileName);
	}
	
	public List<BoardListBean> selectContentList(int boardIndex, RowBounds rowBounds) {
		return boardMapper.selectContentList(boardIndex, rowBounds);
	}
	
	public List<CategoryBean> selectCategoryList(){
		return boardMapper.selectCategoryList();
	}
	
	public String selectUploadFilePath(String fileName) {
		return boardMapper.selectUploadFilePath(fileName);
	}
}
