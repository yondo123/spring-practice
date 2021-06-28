package kr.co.whatTodo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.whatTodo.beans.PostBean;
import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.service.BoardService;

public class PostInterceptor implements HandlerInterceptor{
	private UserInfoBean userInfoBean;
	private BoardService boardService;

	public PostInterceptor(UserInfoBean userInfoBean, BoardService boardService) {
		this.userInfoBean = userInfoBean;
		this.boardService = boardService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int postIndex = Integer.parseInt(request.getParameter("contentIndex"));
		PostBean postBean = boardService.getPostInfo(postIndex);
		if(postBean == null) {
			response.sendRedirect(request.getContextPath() + "/error");
			return false;
		}else {
			String boardPath = postBean.getBoardIndex() == 1 ? "study" : "com";
			if(postBean.getWriterIndex() != userInfoBean.getUserIndex()) {
				response.sendRedirect(request.getContextPath() + "/board/" + boardPath);
				return false;
			}
			return true;
		}
	}
}
