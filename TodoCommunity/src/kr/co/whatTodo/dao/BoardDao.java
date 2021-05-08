package kr.co.whatTodo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.mapper.BoardMapper;

@Repository
public class BoardDao {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public void insertContentInfo(BoardListBean boardListBean) {
		boardMapper.insertContentInfo(boardListBean);
	}
	
	public List<BoardListBean> selectContentList(int boardIndex) {
		return boardMapper.selectContentList(boardIndex);
	}
}
