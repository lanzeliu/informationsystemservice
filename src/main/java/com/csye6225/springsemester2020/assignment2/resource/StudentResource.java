package com.csye6225.springsemester2020.assignment2.resource;

import com.csye6225.springsemester2020.assignment2.model.Course;
import com.csye6225.springsemester2020.assignment2.model.Student;
import com.csye6225.springsemester2020.assignment2.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("/dynamodb/students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {

    StudentService studentService = new StudentService();

    @GET
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GET
    @Path("/{studentId}")
    public Student getOneStudent(@PathParam("studentId") String studentId) {
        return studentService.getStudent(studentId);
    }

    @POST
    public Student addStudent(Student student) {
        return studentService.addStudent(student);
    }

    @PUT
    @Path("/{studentId}")
    public Student updateStudent(@PathParam("studentId") String studentId, Student student) {
        student.setStudentId(studentId);
        return studentService.updateStudent(student);
    }

    @DELETE
    @Path("/{studentId}")
    public void deleteStudent(@PathParam("studentId") String studentId) {
    }

    // /students/studentId/courses

    @GET
    @Path("/{studentId}/courses")
    public List<Course> getCoursesOfOneStudent(@PathParam("studentId") String studentId) {
        return studentService.getCoursesOfOneStudent(studentId);
    }

    @GET
    @Path("/{studentId}/courses/{courseId}")
    public Course getOneCourseOfOneStudent(@PathParam("studentId") String studentId, @PathParam("courseId") String courseId) {
        return studentService.getOneCourseOfOneStudent(studentId, courseId);
    }

    @POST
    @Path("/{studentId}/courses/{courseId}")
    public Set<String> addCourseIntoOneStudent(@PathParam("studentId") String studentId, @PathParam("courseId") String courseId) {
        return studentService.addCourseIntoOneStudent(studentId, courseId);
    }

    @DELETE
    @Path("/{studentId}/courses/{courseId}")
    public void deleteCourseFromStudent(@PathParam("studentId") String studentId, @PathParam("courseId") String courseId) {
        studentService.deleteCourse(studentId, courseId);
    }


}
