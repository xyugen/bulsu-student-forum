package com.pagzone.util;

import com.pagzone.dao.UserDao;
import com.sanctionco.jmail.JMail;
import java.util.regex.Pattern;

public class UserValidator {
    // Regular expression pattern for valid username format (letters, numbers, underscores)
    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_]{3,20}$";
    
    // Regular expression pattern for valid password format (at least 8 characters, at least one digit, one uppercase letter, one lowercase letter, and one special character)
//    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    // At least 8 characters
    private static final String PASSWORD_PATTERN = ".{8,}";
    
    private UserValidator() { }
    
    public static boolean verifyLogin(String username, String password) {
        if (!isValidUsername(username) && !isValidEmail(username)) return false;
        return isValidPassword(password);
    }

    public static boolean verifySignup(String email, String password, String confirmPassword) {
        if (!isValidEmail(email)) {
            return false;
        }
        
        if (!isValidPassword(password)) {
            return false;
        }
        
        if (!password.equals(confirmPassword)) {
            return false;
        }
        
        return true;
    }
    
    public static boolean isValidUsername(String username) {
        return Pattern.compile(USERNAME_PATTERN).matcher(username).matches();
    }

    // Method to validate email format using regular expression
    public static boolean isValidEmail(String email) {
        return JMail.strictValidator().isValid(email);
    }
    
    public static boolean isValidBulsuEmail(String email) {
        return isValidEmail(email) && email.endsWith("@bulsu.edu.ph");
    }

    // Method to validate password format using regular expression
    public static boolean isValidPassword(String password) {
        return Pattern.compile(PASSWORD_PATTERN).matcher(password).matches();
    }
}