package com.csye6225.springsemester2020.service;

import com.csye6225.springsemester2020.database.InMemoryDatabase;
import com.csye6225.springsemester2020.model.Course;
import com.csye6225.springsemester2020.model.Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LectureService {

    private Map<Long, Course> courseMap = InMemoryDatabase.getCourseMap();

    public List<Lecture> getAllLectureOfOneCourse(long courseId) {
        return new ArrayList<>(courseMap.get(courseId).getHavingLectures().values());
    }

    public Lecture getOneLectureOfOneCourse(long courseId, long lectureId) {
        return courseMap.get(courseId).getHavingLectures().get(lectureId);
    }

    public Lecture addLecture(long courseId, Lecture lecture) {
        lecture.setLectureId(courseMap.size() + 1);
        lecture.setPossessedCourseName(courseMap.get(courseId).getName());
        courseMap.get(courseId).getHavingLectures().put(lecture.getLectureId(), lecture);
        return lecture;
    }

    public Lecture updateLecture(long courseId, Lecture lecture) {
        if (lecture.getLectureId() <= 0) {
            return null;
        }
        lecture.setPossessedCourseName(courseMap.get(courseId).getName());
        courseMap.get(courseId).getHavingLectures().put(lecture.getLectureId(), lecture);
        return lecture;
    }

    public Lecture deleteLecture(long courseId, long lectureId) {
        return courseMap.get(courseId).getHavingLectures().remove(lectureId);
    }
}
