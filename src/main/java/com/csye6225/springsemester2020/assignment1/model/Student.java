package com.csye6225.springsemester2020.assignment1.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonPropertyOrder({"studentId", "firstName", "lastName", "imageUrl", "programName", "enrolledCourses"})
public class Student {

    private long studentId;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String programName;
    @JsonIgnore
    private Map<Long, Course> enrolledCourses = new HashMap<>();

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

    @JsonGetter("enrolledCourses")
    public List<String> enrolledCoursesToJson() {
        List<String> list = new ArrayList<>();
        for (Course c : enrolledCourses.values()) {
            list.add(c.getName());
        }
        return list;
    }
}
