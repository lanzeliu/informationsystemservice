package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Lecture;
import com.csye6225.springsemester2020.service.LectureService;

import javax.ws.rs.*;
import java.util.List;

public class LectureOfCourseResource {

    LectureService lectureService = new LectureService();

    @GET
    public List<Lecture> getAllLecturesOfOneCourse(@PathParam("courseId") long courseId) {
        return lectureService.getAllLectureOfOneCourse(courseId);
    }

    @GET
    @Path("/{lectureId}")
    public Lecture getLectureOfOneCourse(@PathParam("courseId") long courseId, @PathParam("lectureId") long lectureId) {
        return lectureService.getOneLectureOfOneCourse(courseId, lectureId);
    }

    @POST
    public Lecture addLecture(@PathParam("courseId") long courseId, Lecture lecture) {
        return lectureService.addLecture(courseId, lecture);
    }

    @PUT
    @Path("/{lectureId}")
    public Lecture updateLectureOfOneCourse(@PathParam("courseId") long courseId, @PathParam("lectureId") long lectureId, Lecture lecture) {
        lecture.setLectureId(lectureId);
        return lectureService.updateLecture(courseId, lecture);
    }

    @DELETE
    @Path("/{lectureId}")
    public void deleteLectureOfOneCourse(@PathParam("courseId") long courseId, @PathParam("lectureId") long lectureId) {
        lectureService.deleteLecture(courseId, lectureId);
    }
}
