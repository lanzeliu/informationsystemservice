package com.csye6225.springsemester2020.assignment1.resource;

import com.csye6225.springsemester2020.assignment1.model.Lecture;
import com.csye6225.springsemester2020.assignment1.service.LectureService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/lectures")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LectureResource {

    LectureService lectureService = new LectureService();

    @GET
    public List<Lecture> getAllLectures() {
        return lectureService.getAllLectures();
    }

    @GET
    @Path("/{lectureId}")
    public Lecture getOneLecture(@PathParam("lectureId") long lectureId) {
        return lectureService.getOneLecture(lectureId);
    }

}
