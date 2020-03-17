package com.csye6225.springsemester2020.assignment1.database;

import com.csye6225.springsemester2020.assignment1.model.*;

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

    static {

        Program program1 = new Program(1L, "CS");
        Program program2 = new Program(2L, "IS");

        Course course1 = new Course(1L, "Discrete Math", "roster1", "board1", program1.getName());
        Course course2 = new Course(2L, "Cloud Computing", "roster2", "board2", program2.getName());

        Student student1 = new Student(1L, "Larry", "Liu", "imageUrl1", program1.getName());
        Student student2 = new Student(2L, "Edison", "Guo", "imageUrl2", program2.getName());

        Lecture lecture1 = new Lecture(1L, "First lecture for Discrete Math", "note1", "assoMaterial1", course1.getName());
        Lecture lecture2 = new Lecture(2L, "First lecture for Cloud Computing", "note2", "assoMaterial2", course2.getName());

        Professor professor1 = new Professor(1L, "Preeti", "", "Department of CS");
        Professor professor2 = new Professor(2L, "Jami", "Avinav", "Department of IS");

        programMap.put(1L, program1);
        programMap.put(2L, program2);

        courseMap.put(1L, course1);
        courseMap.put(2L, course2);

        studentMap.put(1L, student1);
        studentMap.put(2L, student2);

        professorMap.put(professor1.getProfessorId(), professor1);
        professorMap.put(professor2.getProfessorId(), professor2);

        lectureMap.put(1L, lecture1);
        lectureMap.put(2L, lecture2);

        course1.getHavingLectures().put(lecture1.getLectureId(), lecture1);
        course2.getHavingLectures().put(lecture2.getLectureId(), lecture2);

        course1.getHavingStudents().put(student1.getStudentId(), student1);
        course2.getHavingStudents().put(student2.getStudentId(), student2);

        student1.getEnrolledCourses().put(course1.getCourseId(), course1);
        student2.getEnrolledCourses().put(course2.getCourseId(), course2);

        //professor1.getTeachingCourses().put(course1.getCourseId(), course1);
        //professor2.getTeachingCourses().put(course2.getCourseId(), course2);

        program1.getHavingStudents().put(student1.getStudentId(), student1);
        program2.getHavingStudents().put(student2.getStudentId(), student2);

        program1.getHavingCourses().put(course1.getCourseId(), course1);
        program2.getHavingCourses().put(course2.getCourseId(), course2);

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
