/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.service;

import com.pagzone.model.Session;
import com.pagzone.model.User;

/**
 *
 * @author Arias
 */
public class SessionManager {
    private static SessionManager instance;
    private Session currentSession;
    
    private SessionManager() {}
    
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        
        return instance;
    }
    
    public void createSession(User user) {
        currentSession = new Session(user.getUsername());
    }
    
    public boolean isUserLoggedIn() {
        return currentSession != null;
    }
    
    public String getCurrentUsername() {
        return currentSession.getUsername();
    }
    
    public void endSession() {
        currentSession = null;
    }
}
