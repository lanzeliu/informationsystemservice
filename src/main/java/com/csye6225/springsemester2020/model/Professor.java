package com.csye6225.springsemester2020.model;

import java.util.Date;
import java.util.Map;

public class Professor {

    // Local variables
    private long professorId;
    private String firstName;
    private String lastName;
    private String department;
    private Date joiningDate;
    private Map<Long, Course> teachingCourses;
    private String belongedProgram;

    // Default constructor
    public Professor() {

    }

    // Custom constructor
    public Professor(long professorId, String firstName, String lastName, String department) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.joiningDate = new Date();
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

    public Date getJoiningDate() {
        return joiningDate;
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

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Map<Long, Course> getTeachingCourses() {
        return teachingCourses;
    }

    public void setTeachingCourses(Map<Long, Course> teachingCourses) {
        this.teachingCourses = teachingCourses;
    }

    public String getBelongedProgram() {
        return belongedProgram;
    }

    public void setBelongedProgram(String belongedProgram) {
        this.belongedProgram = belongedProgram;
    }
}
