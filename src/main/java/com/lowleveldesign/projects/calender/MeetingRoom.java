package com.lowleveldesign.projects.calender;

import com.lowleveldesign.projects.calender.exceptions.InvalidBookingException;

import java.util.TreeMap;

public class MeetingRoom {
    private TreeMap<Integer,Integer> meetingTimes;
    public MeetingRoom() {
        this.meetingTimes = new TreeMap<Integer,Integer>();
    }

    public boolean checkAndBookMeeting(Integer startTime, Integer endTime)throws InvalidBookingException {
        if(startTime > endTime)
            throw new InvalidBookingException("Start time cannot be greater than end time");

        //Algorithm
        Integer startFloor = this.meetingTimes.floorKey(startTime);
        Integer endFloor = this.meetingTimes.floorKey(endTime);

        if(startFloor == null && endFloor == null) {
            this.meetingTimes.put(startTime, endTime);
            return true;
        }

        if(startFloor == null)
            return false;

        if(startFloor != endFloor)
            return false;

        if(startTime > this.meetingTimes.get(startFloor)) {
            this.meetingTimes.put(startTime, endTime);
            return true;
        }

        return false;
    }
}
