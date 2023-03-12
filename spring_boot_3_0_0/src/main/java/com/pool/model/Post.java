package com.pool.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id
    private Integer id;
    private Integer userId;
    private String title;
    private String body;

    public Post() {
    }

    public Post(Integer id, Integer userId, String title, String body) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", userId=" + userId + ", title=" + title + ", body=" + body + "]";
    }

}
