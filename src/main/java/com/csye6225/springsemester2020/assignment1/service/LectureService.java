package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Course;
import com.csye6225.springsemester2020.model.Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LectureService {

    private Map<Long, Course> courseMap = InMemoryDatabase.getCourseMap();
    private Map<Long, Lecture> lectureMap = InMemoryDatabase.getLectureMap();
    private static long generateId = InMemoryDatabase.getCourseMap().size();

    public List<Lecture> getAllLectures() {
        return new ArrayList<>(lectureMap.values());
    }

    public Lecture getOneLecture(long lectureId) {
        return lectureMap.get(lectureId);
    }

    public List<Lecture> getAllLectureOfOneCourse(long courseId) {
        return new ArrayList<>(courseMap.get(courseId).getHavingLectures().values());
    }

    public Lecture getOneLectureOfOneCourse(long courseId, long lectureId) {
        if (courseMap.get(courseId) == null) {
            return null;
        }
        return courseMap.get(courseId).getHavingLectures().get(lectureId);
    }

    public Lecture addLecture(long courseId, Lecture lecture) {
        lecture.setLectureId(++generateId);
        lecture.setCourseName(courseMap.get(courseId).getName());
        courseMap.get(courseId).getHavingLectures().put(generateId, lecture);
        return lecture;
    }

    public Lecture updateLecture(long courseId, Lecture lecture) {
        Course course = courseMap.get(courseId);
        if (course != null && course.getHavingLectures().containsKey(lecture.getLectureId())) {
            lecture.setCourseName(course.getName());
            course.getHavingLectures().put(lecture.getLectureId(), lecture);
            return lecture;
        }
        return null;
    }

    public void deleteLecture(long courseId, long lectureId) {
        if (courseMap.get(courseId) != null) {
            courseMap.get(courseId).getHavingLectures().remove(lectureId);
        }
    }
}
