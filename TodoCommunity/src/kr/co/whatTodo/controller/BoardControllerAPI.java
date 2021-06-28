package kr.co.whatTodo.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kr.co.whatTodo.beans.BoardListBean;
import kr.co.whatTodo.beans.CategoryBean;
import kr.co.whatTodo.beans.ResponseBean;
import kr.co.whatTodo.service.BoardService;

@RestController
@RequestMapping("/board")
public class BoardControllerAPI {

	@Autowired
	private BoardService boardService;
	@Autowired
	private MessageSource errorMessage;

	// 이미지 파일 등록
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@PostMapping("/image") 
	public ResponseEntity<ResponseBean> image(BoardListBean boardListBean, HttpServletRequest req) {
		MultipartFile imageFile = boardListBean.getUploadFile();
		HttpSession session = req.getSession();
		
		if (imageFile == null) {
			ResponseBean error = new ResponseBean("file empty", false, null);
			return new ResponseEntity<>(error, HttpStatus.OK);
		}
		
		String imageName = boardService.addImageFile(imageFile);
		ArrayList<String> tempImageList = (ArrayList) session.getAttribute("temp_image");
		tempImageList.add(imageName);
		ResponseBean success = new ResponseBean("success", true, imageName);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}


	// 게시글 등록
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@PostMapping("/contentWrite")
	public ResponseEntity<ResponseBean> contentWrite(@Valid @RequestBody BoardListBean boardListBean, BindingResult res, HttpServletRequest req) {
		HttpSession session = req.getSession();
		if (res.hasErrors()) {
			ResponseBean error = new ResponseBean(
					errorMessage.getMessage(res.getAllErrors().get(0), Locale.getDefault()), false, null);
			return new ResponseEntity<>(error, HttpStatus.OK);
		}
		boardService.addPost(boardListBean,(ArrayList) session.getAttribute("temp_image"));
		ResponseBean success = new ResponseBean("success", true, null);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// 게시물 목록 조회
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@GetMapping("/list")
	public ResponseEntity<ResponseBean> getBoardList(@RequestParam(value = "boardIndex") int boardIndex,
			@RequestParam(value = "reqPage") int reqPage) {
		int totalCount = boardService.getContentTotalCount(boardIndex);
		Map result = new HashMap<String, Object>();
		List<BoardListBean> boardList = boardService.getContentList(boardIndex, reqPage);
		result.put("items", boardList);
		result.put("totalCount", totalCount);
		ResponseBean success = new ResponseBean("success", true, result);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}

	// 카테고리 조회
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
	@GetMapping("/category")
	public ResponseEntity<ResponseBean> getBoardCategory(@RequestParam(value = "cateType") String cateType) {
		List<CategoryBean> categoryList = null;
		categoryList = boardService.getCategoryList(cateType);
		ResponseBean success = new ResponseBean("success", true, categoryList);
		return new ResponseEntity<>(success, HttpStatus.OK);
	}
}
