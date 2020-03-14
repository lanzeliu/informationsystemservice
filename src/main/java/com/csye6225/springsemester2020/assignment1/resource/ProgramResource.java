package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Course;
import com.csye6225.springsemester2020.model.Program;
import com.csye6225.springsemester2020.model.Student;
import com.csye6225.springsemester2020.service.CourseService;
import com.csye6225.springsemester2020.service.ProgramService;
import com.csye6225.springsemester2020.service.StudentService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/programs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProgramResource {

    ProgramService programService = new ProgramService();
    CourseService courseService = new CourseService();
    StudentService studentService = new StudentService();

    public ProgramResource() {

    }

    @GET
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @GET
    @Path("/{programId}")
    public Program getOneProgram(@PathParam("programId") long programId) {
        return programService.getOneProgram(programId);
    }

    @POST
    public Program addProgram(Program program) {
        return programService.addProgram(program);
    }

    @PUT
    @Path("/{programId}")
    public Program updateProgram(@PathParam("programId") long programId, Program program) {
        program.setProgramId(programId);
        return programService.updateProgram(program);
    }

    @DELETE
    @Path("/{programId}")
    public Program deleteProgram(@PathParam("programId") long programId) {
        return programService.deleteProgram(programId);
    }

    // CourseOfProgramResource
    @GET
    @Path("/{programId}/courses")
    public List<Course> getAllCoursesOfOneProgram(@PathParam("programId") long programId) {
        return courseService.getAllCoursesOfOneProgram(programId);
    }

    @GET
    @Path("/{programId}/courses/{courseId}")
    public Course getOneCourseOfOneProgram(@PathParam("programId") long programId, @PathParam("courseId") long courseId) {
        return courseService.getOneCourseOfOneProgram(programId, courseId);
    }

    @POST
    @Path("/{programId}/courses")
    public Course addCourseIntoOneProgram(@PathParam("programId") long programId, Course course) {
        return courseService.addCourseOfOneProgram(programId, course);
    }

    @PUT
    @Path("/{programId}/courses/{courseId}")
    public Course updateCourseOfOneProgram(@PathParam("programId") long programId, @PathParam("courseId") long courseId, Course course) {
        course.setCourseId(courseId);
        return courseService.updateCourseOfOneProgram(programId, course);
    }

    @DELETE
    @Path("/{programId}/courses/{courseId}")
    public void deleteCourseFromOneProgram(@PathParam("programId") long programId, @PathParam("courseId") long courseId) {
        courseService.deleteCourseFromOneProgram(programId, courseId);
    }

    // StudentOfProgramResource
    @GET
    @Path("/{programId}/students")
    public List<Student> getAllStudentsOfOneProgram(@PathParam("programId") long programId) {
        return studentService.getAllStudentsOfOneProgram(programId);
    }

    @GET
    @Path("/{programId}/students/{studentId}")
    public Student getOneStudentOfOneProgram(@PathParam("programId") long programId, @PathParam("studentId") long studentId) {
        return studentService.getOneStudentOfOneProgram(programId, studentId);
    }

    @POST
    @Path("/{programId}/students")
    public Student addStudentIntoOneProgram(@PathParam("programId") long programId, Student student) {
        return studentService.addStudentIntoOneProgram(programId, student);
    }

    @PUT
    @Path("/{programId}/students/{studentId}")
    public Student updateStudent(@PathParam("programId") long programId, @PathParam("studentId") long studentId, Student student) {
        student.setStudentId(studentId);
        return studentService.updateStudentOfOneProgram(programId, student);
    }

    @DELETE
    @Path("/{programId}/students/{studentId}")
    public void deleteStudent(@PathParam("programId") long programId, @PathParam("studentId") long studentId) {
        studentService.deleteStudentOfOneProgram(programId, studentId);
    }

    // StudentOfCourseOfProgramResource
    @GET
    @Path("/{programId}/courses/{courseId}/students")
    public List<Student> getAllStudentsOfOneCourseOfOneProgram(@PathParam("programId") long programId,
                                                               @PathParam("courseId") long courseId) {
        return new ArrayList<>(programService.getOneProgram(programId).getHavingCourses().get(courseId).getHavingStudents().values());
    }

    @GET
    @Path("/{programId}/courses/{courseId}/students/{studentId}")
    public Student getOneStudentOfOneCourseOfOneProgram(@PathParam("programId") long programId,
                                                        @PathParam("courseId") long courseId,
                                                        @PathParam("studentId") long studentId) {
        return programService.getOneProgram(programId).getHavingCourses().get(courseId).getHavingStudents().get(studentId);
    }

    @POST
    @Path("/{programId}/courses/{courseId}/students")
    public Student addStudentOfOneCourseOfOneProgram(@PathParam("programId") long programId,
                                                     @PathParam("courseId") long courseId,
                                                     Student student) {
        return studentService.addStudentIntoOneCourseOneProgram(programId, courseId, student);
    }

    @PUT
    @Path("/{programId}/courses/{courseId}/students/{studentId}")
    public Student updateStudentOfOneCourseOfOneProgram(@PathParam("programId") long programId,
                                                        @PathParam("courseId") long courseId,
                                                        @PathParam("studentId") long studentId, Student student) {
        student.setStudentId(studentId);
        return studentService.updateStudentOfOneCourseOfOneProgram(programId, courseId, student);
    }

    @DELETE
    @Path("/{programId}/courses/{courseId}/students/{studentId}")
    public void deleteStudentOfOneCourseOfOneProgram(@PathParam("programId") long programId,
                                                     @PathParam("courseId") long courseId,
                                                     @PathParam("studentId") long studentId) {
        studentService.deleteStudentOfOneProgram(programId, studentId);
    }

    // CourseOfStudentOfProgramResource
    @GET
    @Path("/{programId}/students/{studentId}/courses")
    public List<Course> getAllCoursesOfOneStudentOfOneProgram(@PathParam("programId") long programId,
                                                              @PathParam("studentId") long studentId) {
        return new ArrayList<>(programService.getOneProgram(programId).getHavingStudents().get(studentId).getEnrolledCourses().values());
    }

    @GET
    @Path("/{programId}/students/{studentId}/courses/{courseId}")
    public Course getOneCourseOfOneStudentOfOneProgram(@PathParam("programId") long programId,
                                                       @PathParam("studentId") long studentId,
                                                       @PathParam("courseId") long courseId) {
        return programService.getOneProgram(programId).getHavingStudents().get(studentId).getEnrolledCourses().get(courseId);
    }

    @POST
    @Path("/{programId}/students/{studentId}/courses")
    public Course addCourseOfStudentOfProgram(@PathParam("programId") long programId,
                                              @PathParam("studentId") long studentId,
                                              Course course) {
        return courseService.addCourseOfStudentOfProgram(programId, studentId, course);
    }

    @PUT
    @Path("/{programId}/students/{studentId}/courses/{courseId}")
    public Course updateCourseOfOneStudentOfOneProgram(@PathParam("programId") long programId,
                                                       @PathParam("studentId") long studentId,
                                                       @PathParam("courseId") long courseId,
                                                       Course course) {
        course.setCourseId(courseId);
        return courseService.updateCourseOfOneStudentOfOneProgram(programId, studentId, course);
    }

    @DELETE
    @Path("/{programId}/students/{studentId}/courses/{courseId}")
    public void deleteCourseOfOneStudentOfOneProgram(@PathParam("programId") long programId,
                                                     @PathParam("studentId") long studentId,
                                                     @PathParam("courseId") long courseId) {
        courseService.deleteCourseFromOneProgram(programId, courseId);
    }

}
