package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Student;
import com.csye6225.springsemester2020.service.StudentService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

public class StudentOfProgramResource {

    StudentService studentService = new StudentService();

    @GET
    public List<Student> getAllStudentsOfOneProgram(@PathParam("programId") long programId) {
        return studentService.getAllStudentsOfOneProgram(programId);
    }

    @GET
    @Path("/{studentId}")
    public Student getOneStudentOfOneProgram(@PathParam("programId") long programId, @PathParam("studentId") long studentId) {
        return studentService.getOneStudentOfOneProgram(programId, studentId);
    }

    @POST
    public Student addStudentIntoOneProgram(@PathParam("programId") long programId, Student student) {
        return studentService.addStudentIntoOneProgram(programId, student);
    }
}
