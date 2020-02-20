package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Course;
import com.csye6225.springsemester2020.service.CourseService;

import javax.ws.rs.*;
import java.util.List;

public class CourseOfProgramResource {

    CourseService courseService = new CourseService();

    @GET
    public List<Course> getAllCoursesOfOneProgram(@PathParam("programId") long programId) {
        return courseService.getAllCoursesOfOneProgram(programId);
    }

    @GET
    @Path("/{courseId}")
    public Course getOneCourseOfOneProgram(@PathParam("programId") long programId, @PathParam("courseId") long courseId) {
        return courseService.getOneCourseOfOneProgram(programId, courseId);
    }

    @POST
    public Course addCourseIntoOneProgram(@PathParam("programId") long programId, Course course) {
        return courseService.addCourseOfOneProgram(programId, course);
    }

    @PUT
    @Path("/{courseId}")
    public Course updateCourseOfOneProgram(@PathParam("programId") long programId, @PathParam("courseId") long courseId, Course course) {
        course.setCourseId(courseId);
        return courseService.updateCourseOfOneProgram(programId, course);
    }

    @DELETE
    @Path("/{courseId}")
    public void deleteCourseFromOneProgram(@PathParam("programId") long programId, @PathParam("courseId") long courseId) {
        courseService.deleteCourseFromOneProgram(programId, courseId);
    }
}
