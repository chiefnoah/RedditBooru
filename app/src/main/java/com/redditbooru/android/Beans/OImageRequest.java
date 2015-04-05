package com.redditbooru.android.Beans;

import java.io.Serializable;

/**
 * Created by peder_000 on 4/2/2015.
 */
public class OImageRequest implements Serializable {

    private String cookie;

    private String imageUri = "";
    private String sources = "";
    private int limit = 30;
    private int afterId;
    private String postId;
    private String externalId;
    private long afterDate;
    private String user;
    private String q;


    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getAfterId() {
        return afterId;
    }

    public void setAfterId(int afterId) {
        this.afterId = afterId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public long getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(long afterDate) {
        this.afterDate = afterDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

}
