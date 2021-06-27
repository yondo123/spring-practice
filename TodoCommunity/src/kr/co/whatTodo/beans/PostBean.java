package kr.co.whatTodo.beans;

public class PostBean {
	private int boardIndex;
	private String userName;
	private int userIndex;
	private String writeDate;
	private String cateName;
	private int cateIndex;
	private String contentSubject;
	private String contentContext;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserIndex() {
		return userIndex;
	}

	public void setUserIndex(int userIndex) {
		this.userIndex = userIndex;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public int getCateIndex() {
		return cateIndex;
	}

	public void setCateIndex(int cateIndex) {
		this.cateIndex = cateIndex;
	}

	public String getContentContext() {
		return contentContext;
	}

	public void setContentContext(String contentContext) {
		this.contentContext = contentContext;
	}

	public String getContentSubject() {
		return contentSubject;
	}

	public void setContentSubject(String contentSubject) {
		this.contentSubject = contentSubject;
	}

	public int getBoardIndex() {
		return boardIndex;
	}

	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}

}
