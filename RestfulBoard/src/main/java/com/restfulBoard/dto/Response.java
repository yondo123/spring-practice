package com.restfulBoard.dto;

public class Response<T> {
    private String message;
    private boolean result;
    private T data = null;

    public Response(String message, boolean result, T data) {
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
