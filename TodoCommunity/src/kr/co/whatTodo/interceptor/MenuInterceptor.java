package kr.co.whatTodo.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.whatTodo.beans.BoardInfoBean;
import kr.co.whatTodo.service.MenuService;

public class MenuInterceptor implements HandlerInterceptor {
	private MenuService menuService;

	public MenuInterceptor(MenuService menuService) {
		this.menuService = menuService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<BoardInfoBean> menuList = menuService.getMenuList();
		request.setAttribute("menuList", menuList);
		return true;
	}
}
