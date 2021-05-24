package com.example.wechat.core.entity;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 3:48 下午
 */
public class AccessToken {

    private String token;

    private long expiresTime;

    public boolean isExpired() {
        return System.currentTimeMillis() > expiresTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresTime() {
        return expiresTime;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }
}
