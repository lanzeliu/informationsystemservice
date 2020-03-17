package com.csye6225.springsemester2020.assignment1.resource;

import com.csye6225.springsemester2020.assignment1.model.Course;
import com.csye6225.springsemester2020.assignment1.model.Lecture;
import com.csye6225.springsemester2020.assignment1.model.Student;
import com.csye6225.springsemester2020.assignment1.service.CourseService;
import com.csye6225.springsemester2020.assignment1.service.LectureService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

    CourseService courseService = new CourseService();
    LectureService lectureService = new LectureService();

    @GET
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GET
    @Path("/{courseId}")
    public Course getCourse(@PathParam("courseId") long courseId) {
        return courseService.getOneCourse(courseId);
    }

    @GET
    @Path("/{courseId}/students")
    public List<Student> getAllStudentsOfOneCourse(@PathParam("courseId") long courseId) {
        return courseService.getAllStudentsOfOneCourse(courseId);
    }

    @GET
    @Path("/{courseId}/students/{studentId}")
    public Student getOneStudentOfOneCourse(@PathParam("courseId") long courseId, @PathParam("studentId") long studentId) {
        return courseService.getOneStudentOfOneCourse(courseId, studentId);
    }

    @POST
    @Path("/{courseId}/students/{studentId}")
    public Student addStudentIntoCourse(@PathParam("courseId") long courseId, @PathParam("studentId") long studentId) {
        return courseService.addStudentIntoOneCourse(courseId, studentId);
    }

    @DELETE
    @Path("/{courseId}/students/{studentId}")
    public void deleteStudentFromOneCourse(@PathParam("courseId") long courseId, @PathParam("studentId") long studentId) {
        courseService.deleteStudentFromOneCourse(courseId, studentId);
    }

    // lectureOfCourses
    @GET
    @Path("/{courseId}/lectures")
    public List<Lecture> getAllLecturesOfOneCourses(@PathParam("courseId") long courseId) {
        return new ArrayList<>(courseService.getOneCourse(courseId).getHavingLectures().values());
    }

    @GET
    @Path("/{courseId}/lectures/{lectureId}")
    public Lecture getOneLectureOfOneCourse(@PathParam("courseId") long courseId, @PathParam("lectureId") long lectureId) {
        return lectureService.getOneLectureOfOneCourse(courseId, lectureId);
    }

    @POST
    @Path("/{courseId}/lectures")
    public Lecture addLectureIntoOneCourse(@PathParam("courseId") long courseId, Lecture lecture) {
        return lectureService.addLecture(courseId, lecture);
    }

    @PUT
    @Path("/{courseId}/lectures/{lectureId}")
    public Lecture updateLectureOfOneCourse(@PathParam("courseId") long courseId,
                                            @PathParam("lectureId") long lectureId,
                                            Lecture lecture) {
        lecture.setLectureId(lectureId);
        return lectureService.updateLecture(courseId, lecture);
    }

    @DELETE
    @Path("/{courseId}/lectures/{lectureId}")
    public void deleteLectureOfOneCourse(@PathParam("courseId") long courseId,
                                            @PathParam("lectureId") long lectureId) {
        lectureService.deleteLecture(courseId, lectureId);
    }

}
