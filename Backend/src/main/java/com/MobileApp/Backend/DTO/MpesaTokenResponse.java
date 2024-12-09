package com.MobileApp.Backend.DTO;

public class MpesaTokenResponse {
    private String access_token;
    private String expires_in;

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String accessToken) {
        this.access_token = accessToken;
    }

    public String getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(String expiresIn) {
        this.expires_in = expiresIn;
    }
}

