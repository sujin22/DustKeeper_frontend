package com.example.dustkeeper.retrofit.model;

public class MyResponse {
    private boolean isSuccess;
    private int code;
    private String message;

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
