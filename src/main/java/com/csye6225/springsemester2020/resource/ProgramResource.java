package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Program;
import com.csye6225.springsemester2020.service.ProgramService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/programs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProgramResource {

    ProgramService programService = new ProgramService();

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

    @Path("/{programId}/courses")
    public CourseOfProgramResource getCourseOfProgramResource() {
        return new CourseOfProgramResource();
    }

    @Path("/{programId}/students")
    public StudentOfProgramResource getStudentOfProgramResource() {
        return new StudentOfProgramResource();
    }
}
