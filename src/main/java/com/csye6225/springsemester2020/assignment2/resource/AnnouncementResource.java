package com.csye6225.springsemester2020.assignment2.resource;

import com.csye6225.springsemester2020.assignment2.model.Announcement;
import com.csye6225.springsemester2020.assignment2.service.AnnouncementService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/dynamodb/announcements")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnnouncementResource {
    AnnouncementService announcementService = new AnnouncementService();

    @GET
    public List<Announcement> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    @GET
    @Path("/{announcementId}")
    public Announcement getAnnouncement(@PathParam("announcementId") String announcementId) {
        return announcementService.getAnnouncement(announcementId);
    }

    @POST
    public Announcement addAnnouncement(Announcement announcement) {
        return announcementService.addAnnouncement(announcement);
    }

    @PUT
    @Path("/{announcementId}")
    public Announcement updateAnnouncement(@PathParam("announcementId") String announcementId, Announcement announcement) {
        announcement.setAnnouncementId(announcementId);
        return announcementService.updateAnnouncement(announcement);
    }

    @DELETE
    @Path("/{announcementId}")
    public void deleteAnnouncement(@PathParam("announcementId") String announcementId) {
        announcementService.deleteAnnouncement(announcementId);
    }
}
