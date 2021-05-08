package kr.co.whatTodo.beans;

import java.util.List;

public class ResponseBean<T> {
	private String message;
	private boolean result;
	private T data = null;

	public ResponseBean(String message, boolean result, T data) {
		this.message = message;
		this.result = result;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
