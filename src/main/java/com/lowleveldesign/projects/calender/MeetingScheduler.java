package com.lowleveldesign.projects.calender;

import com.lowleveldesign.projects.calender.exceptions.InvalidBookingException;
import com.lowleveldesign.projects.calender.exceptions.NoSuchUserException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingScheduler {
    private Map<Integer,MeetingRoom> meetingRooms;
    private UserService userService;
    public MeetingScheduler(int numRooms, UserService userService) {
        this.meetingRooms = new HashMap<>();
        this.userService = userService;
        this.init(numRooms);
    }

    private void init(int numRooms) {
        for(int i = 0; i<numRooms; i++)
            this.meetingRooms.put(i, new MeetingRoom());
    }

    public void scheduleMeeting(String agenda, int organiserId, int startTime, int endTime, List<Integer> attendeeIds) throws NoSuchUserException, InvalidBookingException {
        User organiser = this.userService.getUser(organiserId);

        if(organiser == null)
            throw new NoSuchUserException("User with given ID does not exist");

        List<User> attendees = new ArrayList<>();
        for(Integer id: attendeeIds) {
            User attendee = this.userService.getUser(id);

            if(attendee == null)
                throw new NoSuchUserException("User with given ID does not exist");

            attendees.add(attendee);
        }

        attendees.add(organiser);

        for(Map.Entry<Integer, MeetingRoom> entry: this.meetingRooms.entrySet()) {
            MeetingRoom meetingRoom = entry.getValue();

            if(meetingRoom.checkAndBookMeeting(startTime, endTime)) {
                System.out.println("Meeting booked for given time !!!");
                MeetingEvent event = new MeetingEvent(agenda, startTime, endTime, attendees, entry.getKey());
                this.notifyAttendees(event, attendees);
                break;
            }
        }

        System.out.println("All rooms occupied for given time slot");
    }

    private void notifyAttendees(MeetingEvent meetingEvent, List<User> attendees) {
        for(User attendee: attendees)
            attendee.notifyUser(meetingEvent);
    }
}
