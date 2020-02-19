package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService {

    private Map<Long, Student> studentMap = InMemoryDatabase.getStudentMap();

    public StudentService() {

    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public Student getOneStudent(long studentId) {
        return studentMap.get(studentId);
    }

    public Student addStudent(Student student) {
        student.setStudentId(studentMap.size() + 1);
        studentMap.put(student.getStudentId(), student);
        return student;
    }

    public Student updateStudent(Student student) {
        if (student.getStudentId() <= 0) {
            return null;
        }
        studentMap.put(student.getStudentId(), student);
        return student;
    }

    public Student deleteStudent(long studentId) {
        return studentMap.remove(studentId);
    }
}
