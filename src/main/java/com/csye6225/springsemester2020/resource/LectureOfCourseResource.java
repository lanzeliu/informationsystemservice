package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Lecture;
import com.csye6225.springsemester2020.service.LectureService;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import java.util.List;

public class LectureOfCourseResource {

    LectureService lectureService = new LectureService();

    @GET
    public List<Lecture> getAllLecturesOfOneCourse(@PathParam("courseId") long courseId) {
        return lectureService.getAllLectureOfOneCourse(courseId);
    }
}
