package com.restfulBoard.controller;

import com.restfulBoard.dto.Board;
import com.restfulBoard.dto.Response;
import com.restfulBoard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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

    @ResponseBody
    @GetMapping("/list")
    public ResponseEntity<Response<?>> list(@RequestParam int index) {
        int totalCount = boardService.getBoardCount();
        Map<String, Object> result = new HashMap<>();
        List<Board> boardList = boardService.getBoardList(index);
        result.put("items", boardList);
        result.put("totalCount", totalCount);
        Response<?> success = new Response<>("success load list", true, result);
        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}
