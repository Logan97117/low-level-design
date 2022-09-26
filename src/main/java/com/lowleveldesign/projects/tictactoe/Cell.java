package com.lowleveldesign.projects.tictactoe;

public class Cell {
    private TicTacToeSymbol occupant;
    private int row, col;
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void setOccupant(TicTacToeSymbol occupant) {
        this.occupant = occupant;
    }

    public TicTacToeSymbol getOccupant() {
        return occupant;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
