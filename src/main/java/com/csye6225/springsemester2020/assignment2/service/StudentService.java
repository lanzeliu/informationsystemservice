package com.csye6225.springsemester2020.assignment2.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.springsemester2020.assignment2.database.DynamoDBConnector;
import com.csye6225.springsemester2020.assignment2.model.Course;
import com.csye6225.springsemester2020.assignment2.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentService {
    private static DynamoDBMapper mapper = DynamoDBConnector.getMapper();

    public List<Student> getAllStudents() {
        return new ArrayList<>(mapper.scan(Student.class, new DynamoDBScanExpression()));
    }

    public Student getStudent(String studentId) {
        return mapper.load(Student.class, studentId);
    }

    public Student addStudent(Student student) {
        if (student.getStudentId() == null) {
            return null;
        }
        mapper.save(student);
        return mapper.load(Student.class, student.getStudentId());
    }

    public Student updateStudent(Student student) {
        Student s = mapper.load(Student.class, student.getStudentId());
        if (s != null) {
            s.setCourses(student.getCourses());
            s.setDepartment(student.getDepartment());
            s.setFirstName(student.getFirstName());
            s.setLastName(student.getLastName());
            s.setJoiningDate(student.getJoiningDate());
            mapper.save(s);
            return s;
        }
        return null;
    }

    public void deleteStudent(String studentId) {
        Student s = mapper.load(Student.class, studentId);
        if (s != null) {
            mapper.delete(s);
        }
    }

    public List<Course> getCoursesOfOneStudent(String studentId) {
        Student s = mapper.load(Student.class, studentId);
        if (s != null && s.getCourses() == null) {
            return null;
        }
        List<Course> list = new ArrayList<>();
        for (String courseId : s.getCourses()) {
            list.add(mapper.load(Course.class, courseId));
        }
        return list;
    }

    public Course getOneCourseOfOneStudent(String studentId, String courseId) {
        Student s = mapper.load(Student.class, studentId);
        if (s != null && s.getCourses() != null && s.getCourses().contains(courseId)) {
            return mapper.load(Course.class, courseId);
        }
        return null;
    }

    public Set<String> addCourseIntoOneStudent(String studentId, String courseId) {
        Student s = mapper.load(Student.class, studentId);
        Course c = mapper.load(Course.class, courseId);
        if (s != null && c != null) {
            if (s.getCourses() == null) {
                s.setCourses(new HashSet<String>());
            }
            if (c.getStudents() == null) {
                c.setStudents(new HashSet<String>());
            }
            s.getCourses().add(courseId);
            c.getStudents().add(studentId);
            mapper.save(s);
            mapper.save(c);
        }
        return s.getCourses();
    }

    public void deleteCourse(String studentId, String courseId) {
        Student s = mapper.load(Student.class, studentId);
        if (s != null && s.getCourses() != null && s.getCourses().contains(courseId)) {
            Course c = mapper.load(Course.class, courseId);
            c.getStudents().remove(studentId);
            if (c.getStudents().size() == 0) {
                c.setStudents(null);
            }
            mapper.save(c);

            s.getCourses().remove(courseId);
            if (s.getCourses().size() == 0) {
                s.setCourses(null);
            }
            mapper.save(s);
        }
    }
}
