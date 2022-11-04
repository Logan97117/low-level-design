package com.lowleveldesign.projects.bookmyshow.models;

import com.lowleveldesign.projects.bookmyshow.enums.SeatStatus;

public class Seat {
    private String id;
    private SeatStatus status;
    private Integer cost;
    private String userLocked;
    private Long lastLockedTime;
    public Seat() {
        this.status = SeatStatus.AVAILABLE;
    }

    public boolean canSelectSeat(String userId) {
        if(lastLockedTime != null && System.currentTimeMillis() - lastLockedTime > 600000) {
            lastLockedTime = null;
            userLocked = null;
            status = SeatStatus.AVAILABLE;
        }

        return status == SeatStatus.AVAILABLE || userId.equals(userLocked);
    }

    public void selectSeat(String userId) {
        lastLockedTime = System.currentTimeMillis();
        userLocked = userId;
    }

    public boolean canBookSeat(String userId) {
        return status == SeatStatus.AVAILABLE || (status == SeatStatus.LOCKED && userLocked.equals(userId));
    }

    public int bookSeat() {
        status = SeatStatus.NOT_AVAILABLE;
        return this.cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getUserLocked() {
        return userLocked;
    }

    public void setUserLocked(String userLocked) {
        this.userLocked = userLocked;
    }

    public Long getLastLockedTime() {
        return lastLockedTime;
    }

    public void setLastLockedTime(Long lastLockedTime) {
        this.lastLockedTime = lastLockedTime;
    }


}
