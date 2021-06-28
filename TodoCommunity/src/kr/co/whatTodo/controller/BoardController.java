package kr.co.whatTodo.controller;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.whatTodo.beans.PostBean;
import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@Resource(name = "loginUserInfoBean")
	private UserInfoBean userInfoBean;
	
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
	public String write(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("temp_image", new ArrayList<String>());
		return "write";
	}
	
	/**
	 * @desc	: 게시글 조회
	 * @param model
	 * @return	: post.jsp
	 */
	@GetMapping("/post")
	public ModelAndView post(Model model, @RequestParam("contentIndex") int contentIndex, @RequestParam("cateIndex") int cateIndex) {
		ModelAndView mv = new ModelAndView("/post");
		PostBean postBean = boardService.getPostInfo(contentIndex, cateIndex);
		mv.addObject("post", postBean);
		mv.addObject("loginUser", userInfoBean);
		return mv;
	}
}
