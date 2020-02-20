package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Course;
import com.csye6225.springsemester2020.model.Student;
import com.csye6225.springsemester2020.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/courses")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CourseResource {

    CourseService courseService = new CourseService();

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

    @Path("/{courseId}/lectures")
    public LectureOfCourseResource getLectureResource(@PathParam("courseId") long courseId) {
        return new LectureOfCourseResource();
    }
}
