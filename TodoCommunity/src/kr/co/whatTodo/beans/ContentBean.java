package kr.co.whatTodo.beans;

class ContentBean {
	private int CONTENT_INDEX;
	private String CONTENT_SUBJECT;
	private String CONTENT_TEXT;
	private String CONTENT_FILE;
	private int WRITER_INDEX;
	private int BOARD_INDEX;
	private String CONTENT_DATE;

	public int getCONTENT_INDEX() {
		return CONTENT_INDEX;
	}

	public void setCONTENT_INDEX(int cONTENT_INDEX) {
		CONTENT_INDEX = cONTENT_INDEX;
	}

	public String getCONTENT_SUBJECT() {
		return CONTENT_SUBJECT;
	}

	public void setCONTENT_SUBJECT(String cONTENT_SUBJECT) {
		CONTENT_SUBJECT = cONTENT_SUBJECT;
	}

	public String getCONTENT_TEXT() {
		return CONTENT_TEXT;
	}

	public void setCONTENT_TEXT(String cONTENT_TEXT) {
		CONTENT_TEXT = cONTENT_TEXT;
	}

	public String getCONTENT_FILE() {
		return CONTENT_FILE;
	}

	public void setCONTENT_FILE(String cONTENT_FILE) {
		CONTENT_FILE = cONTENT_FILE;
	}

	public int getWRITER_INDEX() {
		return WRITER_INDEX;
	}

	public void setWRITER_INDEX(int wRITER_INDEX) {
		WRITER_INDEX = wRITER_INDEX;
	}

	public int getBOARD_INDEX() {
		return BOARD_INDEX;
	}

	public void setBOARD_INDEX(int bOARD_INDEX) {
		BOARD_INDEX = bOARD_INDEX;
	}

	public String getCONTENT_DATE() {
		return CONTENT_DATE;
	}

	public void setCONTENT_DATE(String cONTENT_DATE) {
		CONTENT_DATE = cONTENT_DATE;
	}

}
