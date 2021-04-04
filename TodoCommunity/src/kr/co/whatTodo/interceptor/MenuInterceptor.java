package kr.co.whatTodo.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.whatTodo.beans.BoardInfoBean;
import kr.co.whatTodo.beans.UserInfoBean;
import kr.co.whatTodo.service.MenuService;

/**
 * @desc : Menu Interceptor (로그인 상태에 따른 메뉴 처리)
 */

public class MenuInterceptor implements HandlerInterceptor {
	private MenuService menuService;
	private UserInfoBean userInfoBean;

	public MenuInterceptor(MenuService menuService, UserInfoBean userInfoBean) {
		this.menuService = menuService;
		this.userInfoBean = userInfoBean;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		List<BoardInfoBean> menuList = menuService.getMenuList();
		request.setAttribute("menuList", menuList);
		request.setAttribute("loginUserInfo", userInfoBean);
		return true;
	}
}
