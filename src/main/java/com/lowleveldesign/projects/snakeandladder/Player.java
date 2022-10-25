package com.lowleveldesign.projects.snakeandladder;

public class Player {
    private User user;
    private int position;
    public Player(User user) {
        this.user = user;
        this.position = 1;
    }

    public User getUser() {
        return user;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
