/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.dao;

import com.pagzone.model.Student;
import com.pagzone.model.User;
import com.pagzone.util.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class UserDao {
    public static boolean insertUser(String email, String password) {
        return insertUser(email, password, "");
    }
    
    public static boolean insertUser(String email, String password, String username) {
        String hashedPassword = Helper.hashPassword(password);
        String sql = "INSERT INTO users (email, password, username) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, hashedPassword);
            stmt.setString(3, username);
            
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // Error occurred or user not inserted
    }
    
    public static boolean updateUsername(int id, String username) {
        String sql = "UPDATE users SET username = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setInt(2, id);
            
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // Error occurred or user not updated
    }
    
    public static User getUserById(int id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null; // User not found
    }
    
    public static User getUserByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null; // User not found
    }
    
    public static User getUserByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null; // User not found
    }
    
    public static User getUserByEmailOrUsername(String value) {
        String sql = "SELECT * FROM users WHERE email = ? OR username = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, value);
            stmt.setString(2, value);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null; // User not found
    }
    
    public static boolean verifyCredentials(String username, String password) {
        String hashedPassword = Helper.hashPassword(password);
        String sql = "SELECT * FROM users WHERE (email = ? OR username = ?) AND password = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, username);
            stmt.setString(3, hashedPassword);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("TEST");
        
        return false;
    }
    
    private static User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setEmail(rs.getString("email"));
        user.setUsername(rs.getString("username"));
        user.setIsAdmin(rs.getBoolean("is_admin"));
        user.setCreationDate(rs.getTimestamp("creation_time"));
        
        Student student = new Student();
        //student.setId(rs.getInt("student_id"));
        user.setStudent(student);
        
        user.setProfilePicture(rs.getBytes("profile_picture"));
        
        return user;
    }
    
    public static boolean hasUsername(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // Error occurred or user not found
    }
}
