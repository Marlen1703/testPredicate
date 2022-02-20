package com.example.testpredicate.exception;


import lombok.Data;

@Data
public class JwtExpiredException {
    private String message;

    public JwtExpiredException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "JwtExpiredException{" +
                "message='" + message + '\'' +
                '}';
    }
}
