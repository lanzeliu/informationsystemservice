package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Lecture;
import com.csye6225.springsemester2020.service.LectureService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LectureResource {

    LectureService lectureService = new LectureService();

    public LectureResource() {

    }

    @GET
    public List<Lecture> getAllLectureOfOneCourse(@PathParam("courseId") long courseId) {
        return lectureService.getAllLectureOfOneCourse(courseId);
    }

    @GET
    @Path("/{lectureId}")
    public Lecture getOneLectureOfOneCourse(@PathParam("courseId") long courseId, @PathParam("lectureId") long lectureId) {
        return lectureService.getOneLectureOfOneCourse(courseId, lectureId);
    }

    @POST
    public Lecture addLecture(@PathParam("courseId") long courseId, Lecture lecture) {
        return lectureService.addLecture(courseId, lecture);
    }

    @PUT
    @Path("/{lectureId}")
    public Lecture updateLecture(@PathParam("CourseId") long courseId, @PathParam("lectureId") long lectureId, Lecture lecture) {
        lecture.setLectureId(lectureId);
        return lectureService.updateLecture(courseId, lecture);
    }

    @DELETE
    @Path("/{lectureId}")
    public Lecture deleteLecture(@PathParam("courseId") long courseId, @PathParam("lectureId") long lectureId) {
        return lectureService.deleteLecture(courseId, lectureId);
    }
}
