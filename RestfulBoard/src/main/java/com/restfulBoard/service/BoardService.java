package com.restfulBoard.service;

import com.restfulBoard.dao.BoardDao;
import com.restfulBoard.dto.Board;
import com.restfulBoard.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    @Resource(name = "loginUser")
    private User loginUser;

    //게시글 추가
    public void addPost(Board board){
        board.setWriter(loginUser.getId());
        boardDao.insertPost(board);
    }

    //게시글 전체갯수 조회
    public int getBoardCount(){
        return boardDao.getBoardSize();
    }

    //게시글 목록 조회
    public List<Board> getBoardList(int index){
        int offset = (index - 1) * 10;
        return boardDao.getBoardList(offset);
    }
}
