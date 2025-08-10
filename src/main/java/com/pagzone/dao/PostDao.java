/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.dao;

import com.pagzone.model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arias
 */
public class PostDao {
    // Create (Insert) operation
    public static boolean createPost(Post post) {
        String sql = "INSERT INTO posts (user_id, title, body, timestamp) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, post.getUser().getId());
            stmt.setString(2, post.getTitle());
            stmt.setString(3, post.getBody());
            stmt.setTimestamp(4, post.getTimestamp());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    // Read (Select) operation - Retrieve all posts
    public static List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        String sql = "SELECT * FROM posts";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Post post = new Post(
                        rs.getInt("id"),
                        UserDao.getUserById(rs.getInt("user_id")),
                        rs.getString("title"),
                        rs.getString("body"),
                        rs.getTimestamp("timestamp")
                );
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception
        }
        return posts;
    }
    
    public static Post getPost(int id) throws SQLException {
        String sql = "SELECT * FROM posts WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Post post = new Post(
                        rs.getInt("id"),
                        UserDao.getUserById(rs.getInt("user_id")),
                        rs.getString("title"),
                        rs.getString("body"),
                        rs.getTimestamp("timestamp")
                );
                return post;
            } else {
                return null;
            }
        }
    }
    
    // Update operation
    public static void updatePost(int postId, Post post) {
        String sql = "UPDATE posts SET title = ?, body = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, post.getTitle());
            stmt.setString(2, post.getBody());
            stmt.setInt(3, postId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception
        }
    }
    
    // Delete operation
    public static void deletePost(int postId) {
        String sql = "DELETE FROM posts WHERE id = ?";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, postId);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception
        }
    }
}
