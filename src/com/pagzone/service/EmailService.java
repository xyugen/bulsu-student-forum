package com.pagzone.service;

import com.pagzone.props.AppConfig;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Arias
 */
public class EmailService {
    public EmailService() {
        String username = AppConfig.getProperty("email.username");
        String password = AppConfig.getProperty("email.password");
    }
}
