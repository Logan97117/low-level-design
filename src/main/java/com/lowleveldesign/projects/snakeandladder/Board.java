package com.lowleveldesign.projects.snakeandladder;

import java.util.Random;

public class Board {
    private Cell cells[];
    private int size;
    public Board(int size, int snakes, int ladders) {
        this.size = size;
        this.cells = new Cell[size*size + 1];
        this.init(snakes, ladders);
    }

    private void init(int snakes, int ladders) {
        Random random = new Random();
        for(int i = 1; i<= this.size*this.size; i++)
            this.cells[i] = new Cell();

        for(int i = 1; i<=ladders; ) {
            int startCell = 1 + random.nextInt(this.size*this.size);
            int endCell = 1 + random.nextInt(this.size*this.size);

            if(endCell <= startCell) continue;

            this.cells[startCell].setJumpTo(endCell);
            i++;
        }

        for(int i = 1; i<=snakes; ) {
            int startCell = 1 + random.nextInt(this.size*this.size);
            int endCell = 1 + random.nextInt(this.size*this.size);

            if(endCell >= startCell) continue;

            this.cells[startCell].setJumpTo(endCell);
            i++;
        }
    }

    public int makeMove(int currentCell, int move) {
        if(currentCell + move > this.size*this.size)
            return 0;

        int newCell = currentCell + move;
        while(this.cells[newCell].getJumpTo() != -1)
            newCell = this.cells[newCell].getJumpTo();

        return newCell;
    }

    public boolean isFinished(int position) {
        return position == this.size*this.size;
    }
}
