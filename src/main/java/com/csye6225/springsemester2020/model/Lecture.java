package com.csye6225.springsemester2020.model;

public class Lecture {

    private long lectureId;
    private String name;
    private String note;
    private String assoMaterial;
    private Course possessedCourse;

    public Lecture() {

    }

    public Lecture(long lectureId, String name, String note, String assoMaterial) {
        this.lectureId = lectureId;
        this.name = name;
        this.note = note;
        this.assoMaterial = assoMaterial;
    }

    public String getName() {
        return name;
    }

    public long getLectureId() {
        return lectureId;
    }

    public String getNote() {
        return note;
    }

    public String getAssoMaterial() {
        return assoMaterial;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAssoMaterial(String assoMaterial) {
        this.assoMaterial = assoMaterial;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getPossessedCourse() {
        return possessedCourse;
    }

    public void setPossessedCourse(Course possessedCourse) {
        this.possessedCourse = possessedCourse;
    }
}
