package com.csye6225.springsemester2020.model;

import java.util.HashMap;
import java.util.Map;

public class Course {

    private long courseId;
    private String name;
    private String roster;
    private String board;
    private Map<Long, Lecture> havingLectures = new HashMap<>();
    private Map<Long, Student> havingStudent = new HashMap<>();
    private Professor professor;
    private Student TA;
    private String possessedProgramName;

    public Course() {

    }

    public Course(long courseId, String name, String roster, String board, String possessedProgram) {
        this.courseId = courseId;
        this.name = name;
        this.roster = roster;
        this.board = board;
        this.possessedProgramName = possessedProgram;
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

    public Map<Long, Student> getHavingStudent() {
        return havingStudent;
    }

    public void setHavingStudent(Map<Long, Student> havingStudent) {
        this.havingStudent = havingStudent;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Student getTA() {
        return TA;
    }

    public void setTA(Student TA) {
        this.TA = TA;
    }

    public String getPossessedProgramName() {
        return possessedProgramName;
    }

    public void setPossessedProgramName(String possessedProgramName) {
        this.possessedProgramName = possessedProgramName;
    }
}
