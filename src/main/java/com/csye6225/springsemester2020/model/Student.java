package com.csye6225.springsemester2020.model;

import java.util.Map;

public class Student {

    private long studentId;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private Map<Long, Course> enrolledCourses;
    private String programName;

    public Student() {

    }

    public Student(long studentId, String firstName, String lastName, String imageUrl, String programName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.programName = programName;
    }

    public long getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Map<Long, Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setEnrolledCourses(Map<Long, Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
