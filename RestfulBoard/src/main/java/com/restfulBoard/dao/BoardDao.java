package com.restfulBoard.dao;

import com.restfulBoard.dto.Board;
import com.restfulBoard.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
    @Autowired
    private BoardMapper boardMapper;

    public void insertPost(Board board){
        boardMapper.insertPost(board);
    }
}
