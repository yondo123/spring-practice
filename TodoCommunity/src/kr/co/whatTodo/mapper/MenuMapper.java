package kr.co.whatTodo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.co.whatTodo.beans.BoardInfoBean;

public interface MenuMapper {
	@Select("SELECT * FROM BOARD_INFO_TABLE")
	List<BoardInfoBean> getMenuList();
}
