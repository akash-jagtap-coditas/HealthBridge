package com.example.HealthBridge.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {
    private T data;
    private long timestamp;
    private String message;
    private int status;

    public ApiResponse(T data, int status, String message) {
        this.data = data;
        this.timestamp = System.currentTimeMillis();
        this.status = status;
        this.message = message;
    }

    public ApiResponse() {

    }

    public ApiResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and Setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
