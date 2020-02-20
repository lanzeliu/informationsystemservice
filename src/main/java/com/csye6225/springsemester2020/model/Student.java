package com.csye6225.springsemester2020.model;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private long studentId;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private Map<Long, Course> enrolledCourses = new HashMap<>();
    private String programName;
    private String TACourse;

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

    public void setEnrolledCourses(Course course) {
        this.enrolledCourses.put(course.getCourseId(), course);
    }

    public void deleteOneEnrolledCourse(long courseId) {
        this.enrolledCourses.remove(courseId);
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getTACourse() {
        return TACourse;
    }

    public void setTACourse(String TACourse) {
        this.TACourse = TACourse;
    }

    public void deleteTACourse() {
        this.TACourse = null;
    }
}
