/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.model;

import java.time.LocalDateTime;

/**
 *
 * @author Arias
 */
public class Session {
    private User user;
    
    public Session(User user) {
        this.user = user;
    }
    
    public User getUser() {
        return user;
    }
}
