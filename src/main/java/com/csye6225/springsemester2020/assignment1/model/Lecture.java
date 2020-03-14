package com.csye6225.springsemester2020.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"lectureId", "name", "note", "assoMaterial", "courseName"})
public class Lecture {

    private long lectureId;
    private String name;
    private String note;
    private String assoMaterial;
    private String courseName;

    public Lecture() {

    }

    public Lecture(long lectureId, String name, String note, String assoMaterial, String courseName) {
        this.lectureId = lectureId;
        this.name = name;
        this.note = note;
        this.assoMaterial = assoMaterial;
        this.courseName = courseName;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
