/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.dao;

import com.pagzone.model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Owner
 */
public class CourseDao {
    public static boolean insertCourse(String courseName) {
        String sql = "INSERT INTO courses (course_name) VALUES (?)";
        
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, courseName);
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    public static boolean editCourse(int courseId, String newCourseName) {
        String sql = "UPDATE courses SET course_name = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newCourseName);
            stmt.setInt(2, courseId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; // Return true if the course was updated successfully
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
    public static boolean deleteCourse(int courseId) {
        String sql = "DELETE FROM courses WHERE id = ?";

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, courseId);

            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0; // Return true if the course was deleted successfully
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static Course getCourse(int id) {
        String sql = "SELECT * FROM courses WHERE id = ?";

        Course course = null;
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    course = new Course();
                    course.setId(id);
                    course.setCourseName(rs.getString("course_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }

    public static List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT * FROM courses";
        

        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Course course = new Course(
                    rs.getInt("id"),
                    rs.getString("course_name"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception
        }
        
        return courses;
    }
}
