package com.lowleveldesign.projects.calender;

import com.lowleveldesign.projects.calender.interfaces.Notifier;

public class User implements Notifier {
    private String userId;
    private String firstName;
    private String lastName;

    public User(String userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public void notifyUser(MeetingEvent meetingEvent) {
        System.out.println("Meeting scheduled: " + meetingEvent.getDescription());
        System.out.println("Room number: " + meetingEvent.getRoomNumber());
        System.out.println("Start time: " + meetingEvent.getStartTime());
        System.out.println("End time: " + meetingEvent.getEndTime());
        System.out.println("Attendees: ");
        for(User user: meetingEvent.getAttendees())
            System.out.print(user.toString());

        System.out.println();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
