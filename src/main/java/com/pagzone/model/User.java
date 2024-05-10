/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.model;

import java.sql.Timestamp;

/**
 *
 * @author alex
 */
public class User {
    private int id;
    private String email;
    private Student student;
    private byte[] profilePicture;
    private boolean isAdmin;
    private Timestamp creationDate;

    public User(int id, String email, Student student, byte[] profilePicture, boolean isAdmin, Timestamp creationDate) {
        this.id = id;
        this.email = email;
        this.student = student;
        this.profilePicture = profilePicture;
        this.isAdmin = isAdmin;
        this.creationDate = creationDate;
    }

    public User() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }
}
