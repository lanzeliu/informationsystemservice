package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Course;
import com.csye6225.springsemester2020.model.Program;
import com.csye6225.springsemester2020.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService {

    private Map<Long, Student> studentMap = InMemoryDatabase.getStudentMap();
    private Map<Long, Program> programMap = InMemoryDatabase.getProgramMap();
    private Map<Long, Course> courseMap = InMemoryDatabase.getCourseMap();
    private static long generateId = InMemoryDatabase.getStudentMap().size();

    public StudentService() {

    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public Student getOneStudent(long studentId) {
        return studentMap.get(studentId);
    }

    public List<Student> getAllStudentsOfOneProgram(long programId) {
        if (programMap.get(programId) == null) {
            return null;
        }
        return new ArrayList<>(programMap.get(programId).getHavingStudents().values());
    }

    public Student getOneStudentOfOneProgram(long programId, long studentId) {
        if (programMap.get(programId) == null) {
            return null;
        }
        return programMap.get(programId).getHavingStudents().get(studentId);
    }

    public Student addStudent(Student student) {
        student.setStudentId(++generateId);
        studentMap.put(student.getStudentId(), student);
        return student;
    }

    public Student addStudentIntoOneProgram(long programId, Student student) {
        student.setProgramName(programMap.get(programId).getName());
        addStudent(student);
        programMap.get(programId).getHavingStudents().put(student.getStudentId(), student);
        return student;
    }

    public Student updateStudent(Student student) {
        if (student.getStudentId() <= 0) {
            return null;
        }
        Student s = studentMap.get(student.getStudentId());
        s.setFirstName(student.getFirstName());
        s.setLastName(student.getLastName());
        s.setImageUrl(student.getImageUrl());
        return s;
    }

    public Student updateStudentOfOneProgram(long programId, Student student) {
        if (programMap.get(programId) != null && programMap.get(programId).getHavingStudents().containsKey(student.getStudentId())) {
            return updateStudent(student);
        }
        return null;
    }

    public Student deleteStudent(long studentId) {
        if (!studentMap.containsKey(studentId)) {
            return null;
        }
        for (long courseId : studentMap.get(studentId).getEnrolledCourses().keySet()) {
            courseMap.get(courseId).getHavingStudents().remove(studentId);
        }
        return studentMap.remove(studentId);
    }

    public Student deleteStudentOfOneProgram(long programId, long studentId) {
        if (deleteStudent(studentId) == null) {
            return null;
        }
        return programMap.get(programId).getHavingStudents().remove(studentId);
    }

    public List<Course> getAllCoursesOfOneStudent(long studentId) {
        return new ArrayList<>(studentMap.get(studentId).getEnrolledCourses().values());
    }

    public Course getOneCourseOfOneStudent(long studentId, long courseId) {
        if (studentMap.get(studentId) == null) {
            return null;
        }
        return studentMap.get(studentId).getEnrolledCourses().get(courseId);
    }

    public List<Course> addCourse(long studentId, long courseId) {
        Student s = studentMap.get(studentId);
        Course c = courseMap.get(courseId);

        if (!s.getEnrolledCourses().containsKey(courseId)) {
            s.getEnrolledCourses().put(courseId, c);
            c.getHavingStudents().put(s.getStudentId(), s);
        }
        return getAllCoursesOfOneStudent(studentId);
    }

    public Student deleteCourseOfOneStudent(long studentId, long courseId) {
        if (studentMap.get(studentId) == null) {
            return null;
        }
        Course c = studentMap.get(studentId).getEnrolledCourses().get(courseId);
        if (c != null) {
            c.getHavingStudents().remove(studentId);
            studentMap.get(studentId).getEnrolledCourses().remove(courseId);
        }
        return studentMap.get(studentId);
    }
}
