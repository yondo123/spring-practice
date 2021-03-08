package kr.co.whatTodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.whatTodo.beans.BoardInfoBean;
import kr.co.whatTodo.dao.MenuDao;

@Service
public class MenuService {
	@Autowired //Dao 클래스 주입 
	private MenuDao menuDao;
	
	public List<BoardInfoBean> getMenuList(){
		List<BoardInfoBean> menuList = menuDao.getMenuList();
		return menuList;
	}
}
