package com.example.wechat.menu.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zengsl
 * @version V1.0
 * @date 2021/5/7 3:54 下午
 */
public abstract class BaseButton {

    private String name;
    private String type;
    private String key;
    private String url;

    @JsonProperty("media_id")
    private String mediaId;

    @JsonProperty("appid")
    private String appId;

    @JsonProperty("pagepath")
    private String pagePath;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }
}
