package com.lowleveldesign.projects.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private Piece cells[][];
    private int boardSize;
    private int remainingCells;
    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cells = new Piece[boardSize][boardSize];
        this.remainingCells = boardSize*boardSize;
    }

    public boolean makeMove(Piece piece, int row, int col) {
        if(this.cells[row][col] != null) {
            System.out.println("The cell is already occupied");
            return false;
        }

        this.cells[row][col] = piece;
        this.remainingCells--;
        return true;
    }

    public void printBoardStatus() {
        StringBuilder board = new StringBuilder();
        for(int i = 0; i<this.boardSize; i++) {
            board.append("|");
            for(int j = 0; j<this.boardSize; j++) {
                board.append(this.cells[i][j] == null? "___": " " + this.cells[i][j].toString() + " ");
                board.append("|");
            }
            board.append("\n");
        }

        System.out.println(board.toString());
    }

    List<List<Integer>> getFreeCells() {
        List<List<Integer>> freeCells = new ArrayList<>();
        for(int i = 0; i<this.boardSize;i++) {
            for(int j = 0; j<this.boardSize; j++) {
                if(this.cells[i][j] == null)
                    freeCells.add(Arrays.asList(new Integer[]{i+1, j+1}));
            }
        }

        return freeCells;
    }

    public boolean checkWinner(Piece piece, int row, int column) {
        boolean rowMatch = true;
        boolean colMatch = true;
        boolean diagonalMatch = true;
        boolean secondDiagonalMatch = true;

        for(int i = 0; i<this.boardSize; i++) {
            if(this.cells[row][i] != piece) {
                rowMatch = false;
                break;
            }
        }

        for(int i = 0; i<this.boardSize; i++) {
            if(this.cells[i][column] != piece) {
                colMatch = false;
                break;
            }
        }

        for(int i = 0; i<this.boardSize; i++) {
            if((this.cells[i][i] != piece) || (row != column)) {
                diagonalMatch = false;
                break;
            }
        }

        for(int i = 0; i<this.boardSize; i++) {
            if((this.cells[i][this.boardSize-i-1] != piece) || (row + column != this.boardSize-1)) {
                secondDiagonalMatch = false;
                break;
            }
        }

        return rowMatch || colMatch || diagonalMatch || secondDiagonalMatch;
    }

    public boolean allCellsOccupied() {
        return this.remainingCells == 0;
    }
}
