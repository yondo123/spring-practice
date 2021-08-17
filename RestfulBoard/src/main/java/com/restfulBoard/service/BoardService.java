package com.restfulBoard.service;

import com.restfulBoard.dao.BoardDao;
import com.restfulBoard.dto.Board;
import com.restfulBoard.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class BoardService {
    @Autowired
    private BoardDao boardDao;

    @Resource(name = "loginUser")
    private User loginUser;

    public void addPost(Board board){
        System.out.println(loginUser.getId());
        board.setWriter(loginUser.getId());
        boardDao.insertPost(board);
    }
}
