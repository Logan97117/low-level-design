package com.lowleveldesign.projects.calender.interfaces;

import com.lowleveldesign.projects.calender.MeetingEvent;

public interface Notifier {
    public void notifyUser(MeetingEvent meetingEvent);
}
