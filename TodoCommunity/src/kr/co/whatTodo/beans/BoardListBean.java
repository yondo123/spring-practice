package kr.co.whatTodo.beans;

import javax.validation.constraints.NotBlank;

public class BoardListBean {
	private int startRow;
	private int endRow;
	private int contentIndex;
	@NotBlank
	private String contentSubject;
	@NotBlank
	private String contentText;
	private String file;
	private int writerIndex;
	private int boardIndex;
}
