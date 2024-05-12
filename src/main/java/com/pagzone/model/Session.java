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
    private String username;
    private LocalDateTime creationTime;
    
    public Session(String username) {
        this.username = username;
        this.creationTime = LocalDateTime.now();
    }
    
    public String getUsername() {
        return username;
    }
}
