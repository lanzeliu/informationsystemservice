package com.csye6225.springsemester2020.assignment1.resource;

import com.csye6225.springsemester2020.assignment1.model.Course;
import com.csye6225.springsemester2020.assignment1.model.Student;
import com.csye6225.springsemester2020.assignment1.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/students")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResource {

    StudentService studentService = new StudentService();

    @GET
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GET
    @Path("/{studentId}")
    public Student getOneStudent(@PathParam("studentId") long studentId) {
        return studentService.getOneStudent(studentId);
    }

    @GET
    @Path("/{studentId}/courses")
    public List<Course> getAllCoursesOfOneStudent(@PathParam("studentId") long studentId) {
        return studentService.getAllCoursesOfOneStudent(studentId);
    }

    @GET
    @Path("/{studentId}/courses/{courseId}")
    public Course getOneCourseOfOneStudent(@PathParam("studentId") long studentId, @PathParam("courseId") long courseId) {
        return studentService.getOneCourseOfOneStudent(studentId, courseId);
    }

    @POST
    @Path("/{studentId}/courses/{courseId}")
    public List<Course> addCourse(@PathParam("studentId") long studentId, @PathParam("courseId") long courseId) {
        return studentService.addCourse(studentId, courseId);
    }

    @DELETE
    @Path("/{studentId}/courses/{courseId}")
    public void deleteCourse(@PathParam("studentId") long studentId, @PathParam("courseId") long courseId) {
        studentService.deleteCourseOfOneStudent(studentId, courseId);
    }
}
