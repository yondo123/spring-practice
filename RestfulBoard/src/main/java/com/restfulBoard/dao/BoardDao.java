package com.restfulBoard.dao;

import com.restfulBoard.dto.Board;
import com.restfulBoard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {
    @Autowired
    private BoardMapper boardMapper;

    public void insertPost(Board board) {
        boardMapper.insertPost(board);
    }

    public int getBoardSize() {
        return boardMapper.getBoardSize();
    }

    public List<Board> getBoardList(int reqPage){
        return boardMapper.getBoardList(reqPage);
    }
}
