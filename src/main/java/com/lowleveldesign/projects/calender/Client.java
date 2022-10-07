package com.lowleveldesign.projects.calender;

import java.util.Arrays;

public class Client {
    public static void main(String[] args)throws Exception {
        //Users
        User user1 = new User("1", "A", "B");
        User user2 = new User("2", "C", "D");
        User user3 = new User("3", "E", "F");
        UserService userService = new UserService();
        userService.addUser(1, user1);
        userService.addUser(2, user2);
        userService.addUser(3, user3);

        //Scheduler
        MeetingScheduler meetingScheduler = new MeetingScheduler(2, userService);
        meetingScheduler.scheduleMeeting("Quick call", 1, 10, 15, Arrays.asList(2, 3));
    }
}
