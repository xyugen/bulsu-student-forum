/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.dao;

import com.pagzone.model.Student;
import com.pagzone.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alex
 */
public class UserDao {
    public static int insertUser(String email, String password) throws SQLException{
        return insertUser("", email, password, "");
    }
    
    public static int insertUser(String studId, String email, String password) throws SQLException {
        return insertUser(studId, email, password, "");
    }
    
    public static int insertUser(String studId, String email, String password, String username) throws SQLException {
        String sql = "INSERT INTO users (stud_id, email, password, username) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, studId);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setString(4, username);
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
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
    
    public static boolean updatePassword(int id, String password) {
        String sql = "UPDATE users SET password = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, password);
            stmt.setInt(2, id);
            
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public static boolean updateUser(int id, String username, String password) {
        String sql = "UPDATE users SET username = ?, password = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setInt(3, id);
            
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
        public static boolean updateUser(int id, User user) {
        String sql = "UPDATE users SET username = ?, email = ?, is_admin = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setBoolean(3, user.isAdmin());
            stmt.setInt(4, id);
            
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getString("username"),
                        StudentDao.getStudent(rs.getString("stud_id")),
                        rs.getBoolean("is_admin"),
                        rs.getTimestamp("creation_time"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception
        }
        return users;
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
    
    public static boolean deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                return true; // User was successfully deleted
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // User not found or error occurred
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
    
    public static boolean getIsAdminById(int id) throws SQLException {
        String sql = "SELECT is_admin FROM users WHERE id = ?";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("is_admin");
                }
            }
        }
        // If no user with the given ID is found, you might choose to throw an exception or handle it differently
        throw new SQLException("No user found with ID: " + id);
    }
    
    public static void updateIsAdminById(int id, boolean isAdmin) throws SQLException {
        String sql = "UPDATE users SET is_admin = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setBoolean(1, isAdmin);
            stmt.setInt(2, id);

            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated == 0) {
                throw new SQLException("No user found with ID: " + id);
            }
        }
    }
    
    public static boolean verifyCredentials(String username, String password) {
        String sql = "SELECT * FROM users WHERE (email = ? OR username = ?) AND password = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, username);
            stmt.setString(3, password);
            
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
        user.setAdmin(rs.getBoolean("is_admin"));
        user.setCreationDate(rs.getTimestamp("creation_time"));
        
        Student student = StudentDao.getStudent(rs.getString("stud_id"));
        user.setStudent(student);
        
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
