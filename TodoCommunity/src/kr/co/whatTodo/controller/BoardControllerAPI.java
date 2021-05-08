package kr.co.whatTodo.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import kr.co.whatTodo.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardControllerAPI {

	@Autowired
	private BoardService boardService;
	@Autowired
	private MessageSource errorMessage;

	// 게시글 등록
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@PostMapping("/contentWrite")
	public ResponseEntity<ResponseBean> contentWrite(@Valid BoardListBean boardListBean, BindingResult res){
		if (res.hasErrors()) {
			ResponseBean error = new ResponseBean(errorMessage.getMessage(res.getAllErrors().get(0),Locale.getDefault()), false, null);
			return new ResponseEntity<>(error, HttpStatus.OK);
		}
		boardService.addPost(boardListBean);
		ResponseBean success = new ResponseBean("success", true, null);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}
	
	//게시물 조회
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@PostMapping("/getBoardList")
	public ResponseEntity<ResponseBean> getBoardList(@RequestBody BoardListBean boardListBean){
		List<BoardListBean> boardList = boardService.getContentList(boardListBean.getBoardIndex());
		ResponseBean success = new ResponseBean("success", true, boardList);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}
	
}
