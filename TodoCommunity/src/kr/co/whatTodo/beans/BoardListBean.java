package kr.co.whatTodo.beans;

import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

public class BoardListBean {
	private int startRow;
	private int endRow;
	private int contentIndex;
	private int cateIndex;
	private String contentContext;
	@NotBlank
	private String contentSubject;
	private String contentText;
	private String file;
	private MultipartFile uploadFile = null;
	private int writerIndex;
	private int boardIndex;
	private String writeDate;
	private String writerId;
	private int reqPage;

	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	public int getContentIndex() {
		return contentIndex;
	}

	public void setContentIndex(int contentIndex) {
		this.contentIndex = contentIndex;
	}

	public int getCateIndex() {
		return cateIndex;
	}

	public void setCateIndex(int cateIndex) {
		this.cateIndex = cateIndex;
	}

	public String getContentSubject() {
		return contentSubject;
	}

	public void setContentSubject(String contentSubject) {
		this.contentSubject = contentSubject;
	}

	public String getContentText() {
		return contentText;
	}

	public void setContentText(String contentText) {
		this.contentText = contentText;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getWriterIndex() {
		return writerIndex;
	}

	public void setWriterIndex(int writerIndex) {
		this.writerIndex = writerIndex;
	}

	public int getBoardIndex() {
		return boardIndex;
	}

	public void setBoardIndex(int boardIndex) {
		this.boardIndex = boardIndex;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public int getReqPage() {
		return reqPage;
	}

	public void setReqPage(int reqPage) {
		this.reqPage = reqPage;
	}

	public String getContentContext() {
		return contentContext;
	}

	public void setContentContext(String contentContext) {
		this.contentContext = contentContext;
	}
}
