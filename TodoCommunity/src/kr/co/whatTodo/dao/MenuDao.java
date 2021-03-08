package kr.co.whatTodo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.whatTodo.beans.BoardInfoBean;
import kr.co.whatTodo.mapper.MenuMapper;

@Repository
public class MenuDao {
	@Autowired //MenuMapper 주입
	private MenuMapper menuMapper;
	
	public List<BoardInfoBean> getMenuList(){
		List<BoardInfoBean> menuList = menuMapper.getMenuList();
		return menuList;
	}
}
