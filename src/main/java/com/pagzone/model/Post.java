/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.model;

import java.sql.Timestamp;

/**
 *
 * @author Arias
 */
public class Post {
    private int id;
    private User user;
    private String title;
    private String body;
    private Timestamp timestamp;

    public Post() {
    }

    public Post(int id) {
        this.id = id;
    }
    
    public Post(int id, User user, String title, String body, Timestamp timestamp) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.body = body;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
