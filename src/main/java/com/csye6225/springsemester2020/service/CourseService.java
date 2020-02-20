package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseService {

    private Map<Long, Course> courseMap = InMemoryDatabase.getCourseMap();
    private Map<Long, Program> programMap = InMemoryDatabase.getProgramMap();
    private Map<Long, Student> studentMap = InMemoryDatabase.getStudentMap();
    private Map<Long, Lecture> lectureMap = InMemoryDatabase.getLectureMap();

    public CourseService() {

    }

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
        return programMap.get(programId).getHavingCourses().get(courseId);
    }

    public Course addCourse(Course course) {
        course.setCourseId(courseMap.size() + 1);
        courseMap.put(course.getCourseId(), course);
        return course;
    }

    public Course addCourseOfOneProgram(long programId, Course course) {
        course.setPossessedProgramName(programMap.get(programId).getName());
        addCourse(course);
        programMap.get(programId).getHavingCourses().put(course.getCourseId(), course);
        return course;
    }

    public Course updateCourse(Course course) {
        if (course.getCourseId() <= 0) {
            return null;
        }

        for (Lecture l : courseMap.get(course.getCourseId()).getHavingLectures().values()) {
            l.setPossessedCourseName(course.getName());
        }

        for (Student s : courseMap.get(course.getCourseId()).getHavingStudent().values()) {
            s.setEnrolledCourses(course);
        }

        course.setProfessor(courseMap.get(course.getCourseId()).getProfessor());
        course.setTA(courseMap.get(course.getCourseId()).getTA());

        courseMap.put(course.getCourseId(), course);
        return course;
    }

    public Course updateCourseOfOneProgram(long programId, Course course) {
        if (programMap.get(programId) != null && programMap.get(programId).getHavingCourses().containsKey(course.getCourseId())) {
            return updateCourse(course);
        }
        return null;
    }

    public Course deleteCourseFromOneProgram(long programId, long courseId) {
        programMap.get(programId).getHavingCourses().remove(courseId);

        for (Long lectureKey : courseMap.get(courseId).getHavingLectures().keySet()) {
            lectureMap.remove(lectureKey);
        }

        for (Student s : courseMap.get(courseId).getHavingStudent().values()) {
            s.deleteOneEnrolledCourse(courseId);
        }

        courseMap.get(courseId).getProfessor().deleteOneTeachingCourse(courseId);
        courseMap.get(courseId).getTA().deleteTACourse();

        return courseMap.remove(courseId);
    }

    public List<Student> getAllStudentsOfOneCourse(long courseId) {
        return new ArrayList<>(courseMap.get(courseId).getHavingStudent().values());
    }

    public Student getOneStudentOfOneCourse(long courseId, long studentId) {
        return courseMap.get(courseId).getHavingStudent().get(studentId);
    }

    public Student addStudentIntoOneCourse(long courseId, long studentId) {
        Student student = studentMap.get(studentId);
        if (student != null && !courseMap.get(courseId).getHavingStudent().containsKey(studentId)) {
            courseMap.get(courseId).getHavingStudent().put(studentId, student);
            student.getEnrolledCourses().put(courseId, courseMap.get(courseId));
            return student;
        }
        return null;
    }

    public void deleteStudentFromOneCourse(long courseId, long studentId) {
        courseMap.get(courseId).getHavingStudent().remove(studentId);
        studentMap.get(studentId).getEnrolledCourses().remove(courseId);
    }


}
