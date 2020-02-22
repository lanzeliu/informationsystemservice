package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Student;
import com.csye6225.springsemester2020.service.StudentService;

import javax.ws.rs.*;
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

    @PUT
    @Path("/{studentId}")
    public Student updateStudent(@PathParam("programId") long programId, @PathParam("studentId") long studentId, Student student) {
        student.setStudentId(studentId);
        return studentService.updateStudentOfOneProgram(programId, student);
    }

    @DELETE
    @Path("/{studentId}")
    public void deleteStudent(@PathParam("programId") long programId, @PathParam("studentId") long studentId) {
        studentService.deleteStudentOfOneProgram(programId, studentId);
    }
}
