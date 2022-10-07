package com.lowleveldesign.projects.calender;

import java.util.List;

public class MeetingEvent {
    private String description;
    private Integer startTime;
    private Integer endTime;
    private List<User> attendees;
    private Integer roomNumber;

    public MeetingEvent(String description, Integer startTime, Integer endTime, List<User> attendees, Integer roomNumber) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.attendees = attendees;
        this.roomNumber = roomNumber;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public void setStartTime(Integer startTime) {
        this.startTime = startTime;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public void setEndTime(Integer endTime) {
        this.endTime = endTime;
    }

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
        this.attendees = attendees;
    }
}
