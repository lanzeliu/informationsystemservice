package com.csye6225.springsemester2020.model;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonPropertyOrder({"courseId", "name", "programName", "roster", "board", "havingLectures", "havingStudents"})
public class Course {

    private long courseId;
    private String name;
    private String roster;
    private String board;
    private String programName;

    @JsonIgnore
    private Map<Long, Lecture> havingLectures = new HashMap<>();
    @JsonIgnore
    private Map<Long, Student> havingStudents = new HashMap<>();

    public Course() {

    }

    public Course(long courseId, String name, String roster, String board, String programName) {
        this.courseId = courseId;
        this.name = name;
        this.roster = roster;
        this.board = board;
        this.programName = programName;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoster() {
        return roster;
    }

    public void setRoster(String roster) {
        this.roster = roster;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public Map<Long, Lecture> getHavingLectures() {
        return havingLectures;
    }

    public void setHavingLectures(Map<Long, Lecture> havingLectures) {
        this.havingLectures = havingLectures;
    }

    public Map<Long, Student> getHavingStudents() {
        return havingStudents;
    }

    public void setHavingStudents(Map<Long, Student> havingStudents) {
        this.havingStudents = havingStudents;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @JsonGetter("havingLectures")
    public List<String> havingLecturesToJson() {
        List<String> list = new ArrayList<>();
        for (Lecture l : havingLectures.values()) {
            list.add(l.getName());
        }
        return list;
    }

    @JsonGetter("havingStudents")
    public List<String> havingStudentsToJson() {
        List<String> list = new ArrayList<>();
        for (Student s : havingStudents.values()) {
            list.add(s.getFirstName() + " " + s.getLastName());
        }
        return list;
    }
}
