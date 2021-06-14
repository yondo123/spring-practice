package kr.co.whatTodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	/**
	 * @desc   : 스터디 게시판 
	 * @return : board.jsp
	 */
	@GetMapping("/study")
	public String study(Model model) {
		model.addAttribute("cateType", "study");
		model.addAttribute("cateName", "스터디");
		return "board";
	}
	
	/**
	 * @desc   : 자유 게시판 (커뮤니티)
	 * @return : board.jsp
	 */
	@GetMapping("/community")
	public String community(Model model) {
		model.addAttribute("cateType", "com");
		model.addAttribute("cateName", "커뮤니티");
		return "board";
	}
	
	/**
	 * @desc   : 글쓰기 (커뮤니티)
	 * @return : write.jsp
	 */
	@GetMapping("/write")
	public String write() {
		return "write";
	}
}
