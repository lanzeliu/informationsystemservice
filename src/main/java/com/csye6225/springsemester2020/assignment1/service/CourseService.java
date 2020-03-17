package com.csye6225.springsemester2020.assignment1.service;

import com.csye6225.springsemester2020.assignment1.database.InMemoryDatabase;
import com.csye6225.springsemester2020.assignment1.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseService {

    private Map<Long, Course> courseMap = InMemoryDatabase.getCourseMap();
    private Map<Long, Program> programMap = InMemoryDatabase.getProgramMap();
    private Map<Long, Student> studentMap = InMemoryDatabase.getStudentMap();
    private static long generateId = InMemoryDatabase.getCourseMap().size();


    public List<Course> getAllCourses() {
        return new ArrayList<>(courseMap.values());
    }

    public List<Course> getAllCoursesOfOneProgram(long programId) {
        return new ArrayList<>(programMap.get(programId).getHavingCourses().values());
    }

    public Course getOneCourse(long courseId) {
        return courseMap.get(courseId);
    }

    public Course getOneCourseOfOneProgram(long programId, long courseId) {
        Program program = programMap.get(programId);
        if (program == null) {
            return null;
        }
        return program.getHavingCourses().get(courseId);
    }

    public Course addCourse(Course course) {
        course.setCourseId(++generateId);
        courseMap.put(course.getCourseId(), course);
        return course;
    }

    public Course addCourseOfOneProgram(long programId, Course course) {
        course.setProgramName(programMap.get(programId).getName());
        addCourse(course);
        programMap.get(programId).getHavingCourses().put(course.getCourseId(), course);
        return course;
    }

    // CourseOfOneStudentOfOneProgram
    public Course addCourseOfStudentOfProgram(long programId, long studentId, Course course) {
        course.setProgramName(programMap.get(programId).getName());
        course.getHavingStudents().put(studentId, studentMap.get(studentId));
        addCourse(course);
        programMap.get(programId).getHavingCourses().put(course.getCourseId(), course);
        studentMap.get(studentId).getEnrolledCourses().put(course.getCourseId(), course);
        return course;
    }

    public Course updateCourse(Course course) {
        if (course.getCourseId() <= 0) {
            return null;
        }

        Course c = courseMap.get(course.getCourseId());
        c.setName(course.getName());
        c.setRoster(course.getRoster());
        c.setBoard(course.getBoard());
        c.setProgramName(course.getProgramName());

        return c;
    }

    public Course updateCourseOfOneProgram(long programId, Course course) {
        if (programMap.get(programId) != null && programMap.get(programId).getHavingCourses().containsKey(course.getCourseId())) {
            return updateCourse(course);
        }
        return null;
    }

    public Course updateCourseOfOneStudentOfOneProgram(long programId, long studentId, Course course) {
        if (studentMap.get(studentId) != null && studentMap.get(studentId).getEnrolledCourses().containsKey(course.getCourseId())) {
            if (programMap.get(programId) != null && programMap.get(programId).getHavingCourses().containsKey(course.getCourseId())) {
                return updateCourse(course);
            }
        }
        return null;
    }

    public Course deleteCourse(long courseId) {
        if (!courseMap.containsKey(courseId)) {
            return null;
        }
        for (long studentKey : courseMap.get(courseId).getHavingStudents().keySet()) {
            studentMap.get(studentKey).getEnrolledCourses().remove(courseId);
        }
        return courseMap.remove(courseId);
    }
    public Course deleteCourseFromOneProgram(long programId, long courseId) {
        if (deleteCourse(courseId) == null) {
            return null;
        }
        programMap.get(programId).getHavingCourses().remove(courseId);
        return getOneCourseOfOneProgram(programId, courseId);
    }

    // ------------------------------------------------------------------------------ //
    public List<Student> getAllStudentsOfOneCourse(long courseId) {
        return new ArrayList<>(courseMap.get(courseId).getHavingStudents().values());
    }

    public Student getOneStudentOfOneCourse(long courseId, long studentId) {
        return courseMap.get(courseId).getHavingStudents().get(studentId);
    }

    public Student addStudentIntoOneCourse(long courseId, long studentId) {
        Student student = studentMap.get(studentId);
        if (student != null && !courseMap.get(courseId).getHavingStudents().containsKey(studentId)) {
            courseMap.get(courseId).getHavingStudents().put(studentId, student);
            student.getEnrolledCourses().put(courseId, courseMap.get(courseId));
            return student;
        }
        return null;
    }

    public void deleteStudentFromOneCourse(long courseId, long studentId) {
        Course course = courseMap.get(courseId);
        if (course != null) {
            if (course.getHavingStudents().containsKey(studentId)) {
                Student s = studentMap.get(studentId);
                course.getHavingStudents().remove(studentId);
                s.getEnrolledCourses().remove(courseId);
            }
        }
    }




}
