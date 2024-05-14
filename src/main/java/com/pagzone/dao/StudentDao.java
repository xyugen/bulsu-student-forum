package com.pagzone.dao;

import com.pagzone.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    private Connection conn;

    public StudentDao(Connection conn) {
        this.conn = conn;
    }

    // Create
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO students (stud_id, first_name, middle_name, last_name, year, course, profile_picture) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, student.getStudId());
            stmt.setString(2, student.getFirstName());
            stmt.setString(3, student.getMiddleName());
            stmt.setString(4, student.getLastName());
            stmt.setInt(5, student.getYear());
            stmt.setString(6, student.getCourse());
            stmt.setBytes(7, student.getProfilePicture());
            stmt.executeUpdate();
        }
    }
    
    public Student getStudent(int studId) throws SQLException {
        String sql = "SELECT * FROM students WHERE id = ? OR stud_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE students SET first_name = ?, middle_name = ?, last_name = ?, year = ?, course = ?, profile_picture = ? WHERE id = ? OR stud_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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
    public void deleteStudent(int studId) throws SQLException {
        String sql = "DELETE FROM students WHERE id = ? OR stud_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studId);
            stmt.setInt(2, studId);
            stmt.executeUpdate();
        }
    }

    // Get all students
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement()) {
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
