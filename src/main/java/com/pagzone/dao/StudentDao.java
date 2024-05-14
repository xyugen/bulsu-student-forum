package com.pagzone.dao;

import com.pagzone.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    // Create
    public static int insertStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (stud_id, first_name, middle_name, last_name, year, course, profile_picture) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, student.getStudId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getMiddleName());
            stmt.setString(4, student.getLastName());
            stmt.setInt(5, student.getYear());
            stmt.setString(6, student.getCourse());
            stmt.setBytes(7, student.getProfilePicture());
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected == 0) {
                throw new SQLException("Creating student failed, no rows affected.");
            }
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating student failed, no ID obtained.");
                }
            }
        }
    }
    
    public static Student getStudent(int studId) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ? OR stud_id = ?";
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studId);
            stmt.setInt(1, studId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudId(rs.getInt("stud_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setMiddleName(rs.getString("middle_name"));
                student.setLastName(rs.getString("last_name"));
                student.setYear(rs.getInt("year"));
                student.setCourse(rs.getString("course"));
                student.setProfilePicture(rs.getBytes("profile_picture"));
                return student;
            } else {
                return null;
            }
        }
    }

    // Update
    public static void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET first_name = ?, middle_name = ?, last_name = ?, year = ?, course = ?, profile_picture = ? WHERE id = ? OR stud_id = ?";
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getFirstName());
            stmt.setString(2, student.getMiddleName());
            stmt.setString(3, student.getLastName());
            stmt.setInt(4, student.getYear());
            stmt.setString(5, student.getCourse());
            stmt.setBytes(6, student.getProfilePicture());
            stmt.setInt(7, student.getId());
            stmt.setInt(8, student.getStudId());
            stmt.executeUpdate();
        }
    }

    // Delete
    public static void deleteStudent(int studId) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ? OR stud_id = ?";
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
              PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studId);
            stmt.setInt(2, studId);
            stmt.executeUpdate();
        }
    }

    // Get all students
    public static List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Connection conn = DatabaseConnection.getDataSource().getConnection();
              Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setStudId(rs.getInt("stud_id"));
                student.setFirstName(rs.getString("first_name"));
                student.setMiddleName(rs.getString("middle_name"));
                student.setLastName(rs.getString("last_name"));
                student.setYear(rs.getInt("year"));
                student.setCourse(rs.getString("course"));
                student.setProfilePicture(rs.getBytes("profile_picture"));
                students.add(student);
            }
        }
        return students;
    }
}
