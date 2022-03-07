package com.mysite.core.beans;

public class HttpClientResponse {

    private int code;

    private String responseBody;


    public HttpClientResponse(String message, int code) {
        this.responseBody = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
