package com.csye6225.springsemester2020.database;

import com.csye6225.springsemester2020.model.*;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {

    private static Map<Long, Professor> professorMap = new HashMap<>();
    private static Map<Long, Course> courseMap = new HashMap<>();
    private static Map<Long, Lecture> lectureMap = new HashMap<>();
    private static Map<Long, Program> programMap = new HashMap<>();
    private static Map<Long, Student> studentMap = new HashMap<>();

    public InMemoryDatabase() {

    }

    public static Map<Long, Professor> getProfessorMap() {
        return professorMap;
    }

    public static Map<Long, Course> getCourseMap() {
        return courseMap;
    }

    public static Map<Long, Lecture> getLectureMap() {
        return lectureMap;
    }

    public static Map<Long, Program> getProgramMap() {
        return programMap;
    }

    public static Map<Long, Student> getStudentMap() {
        return studentMap;
    }
}
