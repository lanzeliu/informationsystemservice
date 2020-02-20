package com.csye6225.springsemester2020.model;

public class Lecture {

    private long lectureId;
    private String name;
    private String note;
    private String assoMaterial;
    private String possessedCourseName;

    public Lecture() {

    }

    public Lecture(long lectureId, String name, String note, String assoMaterial, String possessedCourseName) {
        this.lectureId = lectureId;
        this.name = name;
        this.note = note;
        this.assoMaterial = assoMaterial;
        this.possessedCourseName = possessedCourseName;
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

    public String getPossessedCourseName() {
        return possessedCourseName;
    }

    public void setPossessedCourseName(String possessedCourseName) {
        this.possessedCourseName = possessedCourseName;
    }
}
