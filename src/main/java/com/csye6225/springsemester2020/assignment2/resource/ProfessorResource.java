package com.csye6225.springsemester2020.assignment2.resource;

import com.csye6225.springsemester2020.assignment2.model.Professor;
import com.csye6225.springsemester2020.assignment2.service.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/dynamodb/professors")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorResource {
    ProfessorService professorService = new ProfessorService();

    @GET
    public List<Professor> getProfessors() {
        return professorService.getAllProfessors();
    }

    @GET
    @Path("/{professorId}")
    public Professor getProfessor(@PathParam("professorId") String professorId) {
        return professorService.getProfessor(professorId);
    }

    @POST
    public Professor addProfessor(Professor professor) {
        return professorService.addProfessor(professor);
    }

    @PUT
    @Path("/{professorId}")
    public Professor updateProfessor(@PathParam("professorId") String professorId, Professor professor) {
        professor.setProfessorId(professorId);
        professorService.updateProfessor(professor);
        return professor;
    }

    @DELETE
    @Path("/{professorId}")
    public void deleteProfessor(@PathParam("professorId") String professorId) {
        professorService.deleteProfessor(professorId);
    }


}
