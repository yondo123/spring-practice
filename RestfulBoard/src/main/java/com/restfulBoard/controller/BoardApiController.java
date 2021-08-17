package com.restfulBoard.controller;

import com.restfulBoard.dto.Board;
import com.restfulBoard.dto.Response;
import com.restfulBoard.dto.User;
import com.restfulBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/board")
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private MessageSource errorMessage;

    @ResponseBody
    @PostMapping("/write")
    public ResponseEntity<Response<?>> write(@Valid @RequestBody Board board, BindingResult result) {
        if (result.hasErrors()) {
            Response<?> error = new Response<>(errorMessage.getMessage(result.getAllErrors().get(0), Locale.getDefault()), false, null);
            return new ResponseEntity<>(error, HttpStatus.OK);
        }
        boardService.addPost(board);
        Response<?> success = new Response<>("success upload post", true, null);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}
