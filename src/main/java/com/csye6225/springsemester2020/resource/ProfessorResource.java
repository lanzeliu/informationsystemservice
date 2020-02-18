package com.csye6225.springsemester2020.resource;

import com.csye6225.springsemester2020.model.Professor;
import com.csye6225.springsemester2020.service.ProfessorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/professors")
public class ProfessorResource {

    ProfessorService professorService = new ProfessorService();

    public ProfessorResource() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getAllProfessors() {
        return professorService.getAllProfessors();
    }

    @GET
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor getOneProfessor(@PathParam("professorId") long professorId) {
        return professorService.getOneProfessor(professorId);
    }

    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Professor> getProfessorByDepartment(@QueryParam("department") String department) {
        if (department == null) {
            return professorService.getAllProfessors();
        }
        return professorService.getProfessorsByDepartment(department);
    }

     */

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor postProfessor(Professor professor) {
        return professorService.postProfessor(professor);
    }

    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor putProfessor(@PathParam("professorId") long professorId, Professor professor) {
        professor.setProfessorId(professorId);
        return professorService.putProfessor(professor);
    }

    @DELETE
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor deleteProfessor(@PathParam("professorId") long professorId) {
        return professorService.deleteProfessor(professorId);
    }
}
