package com.lowleveldesign.projects.snakeandladder;

public class Cell {
    private int jumpTo;

    public Cell() {
        this.jumpTo = -1;
    }

    public int getJumpTo() {
        return jumpTo;
    }

    public void setJumpTo(int jumpTo) {
        this.jumpTo = jumpTo;
    }
}
