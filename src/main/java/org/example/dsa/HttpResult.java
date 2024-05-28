package org.example.dsa;


public class HttpResult<T> {
    private String reasonPhrase;
    private T result;
    private int statusCode;

    public HttpResult(T result, int statusCode, String reasonPhrase) {
        this.result = result;
        this.statusCode = statusCode;
        this.reasonPhrase = reasonPhrase;
    }

    public T getResult() {
        return result;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

}