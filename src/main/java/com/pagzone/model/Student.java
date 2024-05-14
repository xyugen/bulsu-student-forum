/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pagzone.model;

/**
 *
 * @author alex
 */
public class Student {
    private int id;
    private int studId;
    private String firstName;
    private String middleName;
    private String lastName;
    private int year;
    private String course;
    private byte[] profilePicture;

    public Student(int id, int studId, String firstName, String middleName, String lastName, int year, String course, byte[] profilePicture) {
        this.id = id;
        this.studId = studId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.course = course;
    }

    public Student() { }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
    
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
}
