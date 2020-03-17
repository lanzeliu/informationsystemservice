package com.csye6225.springsemester2020.assignment2.resource;

import com.csye6225.springsemester2020.assignment2.model.Course;
import com.csye6225.springsemester2020.assignment2.model.Student;
import com.csye6225.springsemester2020.assignment2.service.CourseService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("dynamodb/courses")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CourseResource {

    CourseService courseService = new CourseService();

    @GET
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GET
    @Path("/{courseId}")
    public Course getCourse(@PathParam("courseId") String courseId) {
        return courseService.getCourse(courseId);
    }

    @POST
    public Course addCourse(Course course) {
        return courseService.addCourse(course);
    }

    @PUT
    @Path("/{courseId}")
    public Course updateCourse(@PathParam("courseId") String courseId, Course course) {
        course.setCourseId(courseId);
        return courseService.updateCourse(course);
    }

    @DELETE
    @Path("/{courseId}")
    public void deleteCourse(@PathParam("courseId") String courseId) {
        courseService.deleteCourse(courseId);
    }

    // courses/courseId/students
    @GET
    @Path("/{courseId}/students")
    public List<Student> getAllStudentsOfOneCourse(@PathParam("courseId") String courseId) {
        return courseService.getAllStudentsOfOneCourse(courseId);
    }

    @GET
    @Path("/{courseId}/students/{studentId}")
    public Student getOneStudentOfOneCourse(@PathParam("courseId") String courseId, @PathParam("studentId") String studentId) {
        return courseService.getOneStudentOfOneCourse(courseId, studentId);
    }

    @POST
    @Path("/{courseId}/students")
    public Set<String> addStudentIntoOneCourse(@PathParam("courseId") String courseId, Student student) {
        return courseService.addStudentIntoOneCourse(courseId, student);
    }

    @DELETE
    @Path("/{courseId}/students/{studentId}")
    public void deleteStudentOfOneCourse(@PathParam("courseId") String courseId, @PathParam("studentId") String studentId) {
        courseService.deleteStudentOfOneCourse(courseId, studentId);
    }

}
