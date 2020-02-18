package com.csye6225.springsemester2020.model;

import java.util.Map;

public class Program {

    private long programId;
    private String name;
    private Map<Long, Course> havingCourses;
    private Map<Long, Student> havingStudents;

    public Program() {

    }

    public Program(long programId, String name) {
        this.programId = programId;
        this.name = name;
    }

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Long, Course> getHavingCourses() {
        return havingCourses;
    }

    public void setHavingCourses(Map<Long, Course> havingCourses) {
        this.havingCourses = havingCourses;
    }

    public Map<Long, Student> getHavingStudents() {
        return havingStudents;
    }

    public void setHavingStudents(Map<Long, Student> havingStudents) {
        this.havingStudents = havingStudents;
    }
}
