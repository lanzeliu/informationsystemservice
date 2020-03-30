package com.csye6225.springsemester2020.assignment2.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.csye6225.springsemester2020.assignment2.database.DynamoDBConnector;
import com.csye6225.springsemester2020.assignment2.model.Announcement;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementService {
    DynamoDBMapper mapper = DynamoDBConnector.getMapper();

    public List<Announcement> getAllAnnouncements() {
        return new ArrayList<>(mapper.scan(Announcement.class, new DynamoDBScanExpression()));
    }

    public Announcement getAnnouncement(String announcementId) {
        return mapper.load(Announcement.class, announcementId);
    }

    public Announcement addAnnouncement(Announcement announcement) {
        mapper.save(announcement);
        return announcement;
    }

    public Announcement updateAnnouncement(Announcement announcement) {
        Announcement a = mapper.load(Announcement.class, announcement.getAnnouncementId());
        if (a != null) {
            a.setAnnouncementText(announcement.getAnnouncementText());
            a.setBoardId(announcement.getBoardId());
            mapper.save(a);
            return a;
        }
        return null;
    }

    public void deleteAnnouncement(String announcementId) {
        Announcement a = mapper.load(Announcement.class, announcementId);
        if (a != null) {
            mapper.delete(a);
        }
    }
}
