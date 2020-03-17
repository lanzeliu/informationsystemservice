package com.csye6225.springsemester2020.assignment2.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.springsemester2020.assignment2.database.DynamoDBConnector;
import com.csye6225.springsemester2020.assignment2.model.Board;
import com.csye6225.springsemester2020.assignment2.model.Course;
import com.csye6225.springsemester2020.assignment2.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseService {

    private static DynamoDBMapper mapper = DynamoDBConnector.getMapper();

    public List<Course> getAllCourses() {
        return new ArrayList<>(mapper.scan(Course.class, new DynamoDBScanExpression()));
    }

    public Course getCourse(String courseId) {
        return mapper.load(Course.class, courseId);
    }

    public Course addCourse(Course course) {
        mapper.save(course);
        return course;
    }

    public Course updateCourse(Course course) {
        Course c = mapper.load(Course.class, course.getCourseId());
        c.setName(course.getName());
        c.setBoardId(course.getBoardId());
        c.setDepartment(course.getDepartment());
        c.setProfessorId(course.getProfessorId());
        c.setStudents(course.getStudents());
        mapper.save(c);
        return c;
    }

    public void deleteCourseFromStudents(String courseId) {
        Course c = mapper.load(Course.class, courseId);
        if (c != null && c.getStudents() != null) {
            for (String studentId : c.getStudents()) {
                Student s = mapper.load(Student.class, studentId);
                if (s != null && s.getCourses() != null) {
                    s.getCourses().remove(c.getCourseId());
                    if (s.getCourses().size() == 0) {
                        s.setCourses(null);
                    }
                    mapper.save(s);
                }
            }
        }
    }

    public void deleteCourse(String courseId) {
        deleteCourseFromStudents(courseId);
        Course c = mapper.load(Course.class, courseId);
        Board b = mapper.load(Board.class, c.getBoardId());
        b.setCourseId(null);
        mapper.save(b);
        mapper.delete(c);
    }

    // Students

    public List<Student> getAllStudentsOfOneCourse(String courseId) {
        Course c = mapper.load(Course.class, courseId);
        List<Student> list = new ArrayList<>();
        if (c != null && c.getStudents() != null) {
            for (String studentId : c.getStudents()) {
                list.add(mapper.load(Student.class, studentId));
            }
        }
        return list;
    }

    public Student getOneStudentOfOneCourse(String courseId, String studentId) {
        Course c = mapper.load(Course.class, courseId);
        if (c != null && c.getStudents() != null && c.getStudents().contains(studentId)) {
            return mapper.load(Student.class, studentId);
        }
        return null;
    }

    public Set<String> addStudentIntoOneCourse(String courseId, Student student) {
        Course c = mapper.load(Course.class, courseId);
        Student s = mapper.load(Student.class, student.getStudentId());
        if (s != null && c != null) {
            if (c.getStudents() == null) {
                c.setStudents(new HashSet<String>());
            }
            if (s.getCourses() == null) {
                s.setCourses(new HashSet<String>());
            }
            c.getStudents().add(student.getStudentId());
            s.getCourses().add(courseId);
            mapper.save(s);
            mapper.save(c);
        }
        return c.getStudents();
    }

    public void deleteStudentOfOneCourse(String courseId, String studentId) {
        Course c = mapper.load(Course.class, courseId);
        if (c != null && c.getStudents() != null && c.getStudents().contains(studentId)) {
            c.getStudents().remove(studentId);
            if (c.getStudents().size() == 0) {
                c.setStudents(null);
            }
            mapper.save(c);

            Student s = mapper.load(Student.class, studentId);
            s.getCourses().remove(courseId);
            if (s.getCourses().size() == 0) {
                s.setCourses(null);
            }
            mapper.save(s);
        }
    }


}
