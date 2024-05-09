/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author Arias
 */
public class OTPDao {
    public static boolean insertOTP(String email, String otpCode) {
        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            String sql = "INSERT INTO otp (email, otp_code, expiration_time, is_used) VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, otpCode);
                stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now().plusMinutes(15)));
                stmt.setBoolean(4, false);
                
                int rowsAffected = stmt.executeUpdate();
                
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean verifyOTP(String email, String otpCode) {
        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            // SQL query to retrieve OTP details for the given email and code
            String sql = "SELECT * FROM otp WHERE email = ? AND otp_code = ? AND expiration_time > ? AND is_used = false";
            
            // Prepare statement
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, otpCode);
                stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                
                // Execute query
                try (ResultSet rs = stmt.executeQuery()) {
                    // If OTP record found and not expired
                    if (rs.next()) {
                        // Mark OTP as used
                        markOTPAsUsed(conn, rs.getInt("id"));
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log exception
        }
        return false;
    }

    private static void markOTPAsUsed(Connection conn, int otpId) throws SQLException {
        // SQL update to mark OTP as used
        String sql = "UPDATE otp SET is_used = true WHERE id = ?";
        
        // Prepare statement
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, otpId);
            
            // Execute update
            stmt.executeUpdate();
        }
    }
}
