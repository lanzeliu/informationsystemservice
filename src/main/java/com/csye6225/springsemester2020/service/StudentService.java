package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Program;
import com.csye6225.springsemester2020.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentService {

    private Map<Long, Student> studentMap = InMemoryDatabase.getStudentMap();
    private Map<Long, Program> programMap = InMemoryDatabase.getProgramMap();

    public StudentService() {

    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(studentMap.values());
    }

    public Student getOneStudent(long studentId) {
        return studentMap.get(studentId);
    }

    public List<Student> getAllStudentsOfOneProgram(long programId) {
        return new ArrayList<>(programMap.get(programId).getHavingStudents().values());
    }

    public Student getOneStudentOfOneProgram(long programId, long studentId) {
        return programMap.get(programId).getHavingStudents().get(studentId);
    }

    public Student addStudent(Student student) {
        student.setStudentId(studentMap.size() + 1);
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
        studentMap.put(student.getStudentId(), student);
        return student;
    }

    public Student deleteStudent(long studentId) {
        return studentMap.remove(studentId);
    }
}
