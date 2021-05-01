package kr.co.whatTodo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.dao.BoardDao;

@Service
public class BoardService {
	@Autowired
	private BoardDao boardDao;
	
	//게시판 글 쓰기
	public void addPost(BoardListBean boardListBean) {
		System.out.println(boardListBean.toString());
	}
}
