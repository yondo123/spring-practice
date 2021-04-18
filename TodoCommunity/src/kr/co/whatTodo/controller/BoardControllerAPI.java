package kr.co.whatTodo.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.beans.ResponseBean;

@RestController
@RequestMapping("/board")
public class BoardControllerAPI {
	@Autowired
	BoardListBean boardListBean;
	/**
	 * @desc : 글 등록
	 */
//	@ResponseBody
//	@PostMapping("/post")
//	public ResponseEntity<BoardListBean> post(@Valid @RequestBody BoardListBean boardListBean, BindingResult res){
//		
//	}
}
