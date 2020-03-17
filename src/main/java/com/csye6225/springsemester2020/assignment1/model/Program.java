package com.csye6225.springsemester2020.assignment1.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program {

    private long programId;
    private String name;
    @JsonIgnore
    private Map<Long, Course> havingCourses = new HashMap<>();
    @JsonIgnore
    private Map<Long, Student> havingStudents = new HashMap<>();
    //@JsonIgnore
    //private Map<Long, Professor> havingProfessors = new HashMap<>();

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

    /*public Map<Long, Professor> getHavingProfessors() {
        return havingProfessors;
    }

    public void setHavingProfessors(Map<Long, Professor> havingProfessors) {
        this.havingProfessors = havingProfessors;
    }

     */

    @JsonGetter("havingStudents")
    public List<String> havingStudentsToJson() {
        List<String> list = new ArrayList<>();
        for (Student s : havingStudents.values()) {
            list.add(s.getFirstName() + " " + s.getLastName());
        }
        return list;
    }

    @JsonGetter("havingCourses")
    public List<String> havingCoursesToJson() {
        List<String> list = new ArrayList<>();
        for (Course c : havingCourses.values()) {
            list.add(c.getName());
        }
        return list;
    }

    /*
    @JsonGetter("havingProfessors")
    public List<String> havingProfessorsToJson() {
        List<String> list = new ArrayList<>();
        for (Professor p : havingProfessors.values()) {
            list.add(p.getFirstName() + " " + p.getLastName());
        }
        return list;
    }

     */
}
