package com.csye6225.springsemester2020.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Professor {

    // Local variables
    private long professorId;
    private String firstName;
    private String lastName;
    private String department;
    private String belongedProgramName;
    @JsonIgnore
    private Map<Long, Course> teachingCourses;

    // Default constructor
    public Professor() {

    }

    // Custom constructor
    public Professor(long professorId, String firstName, String lastName, String department, String belongedProgramName) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.belongedProgramName = belongedProgramName;
    }

    // Getter
    public long getProfessorId() {
        return professorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    // Setter
    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Map<Long, Course> getTeachingCourses() {
        return teachingCourses;
    }

    public void setTeachingCourses(Course course) {
        this.teachingCourses.put(course.getCourseId(), course);
    }

    public void deleteOneTeachingCourse(long courseId) {
        this.teachingCourses.remove(courseId);
    }

    public String getBelongedProgramName() {
        return belongedProgramName;
    }

    public void setBelongedProgramName(String belongedProgramName) {
        this.belongedProgramName = belongedProgramName;
    }

    public void setTeachingCourses(Map<Long, Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }

    @JsonGetter("teachingCourses")
    public List<String> teachingCoursesToJson() {
        List<String> list = new ArrayList<>();
        for (Course c : teachingCourses.values()) {
            list.add(c.getName());
        }
        return list;
    }

}
