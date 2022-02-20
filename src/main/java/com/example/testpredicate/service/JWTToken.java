package com.example.testpredicate.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import org.springframework.security.core.userdetails.User;


public class JWTToken implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accessToken;

    private User user;

    public JWTToken(String idToken, User user) {
        this.accessToken = idToken;
        this.user = user;
    }

    @JsonProperty("token")
    public String getAccessToken() {
        return this.accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
