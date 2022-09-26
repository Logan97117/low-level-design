package com.lowleveldesign.projects.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    private Cell cells[][];
    private int boardSize;
    private int remainingCells;
    public Board(int boardSize) {
        this.boardSize = boardSize;
        this.cells = new Cell[boardSize][boardSize];
        for(int i = 0; i<boardSize; i++) {
            for(int j = 0; j<boardSize; j++)
                this.cells[i][j] = new Cell(i, j);
        }

        this.remainingCells = boardSize*boardSize;
    }

    public boolean makeMove(TicTacToeSymbol player, int row, int col) {
        if(this.cells[row][col].getOccupant() != null)
            return false;

        this.cells[row][col].setOccupant(player);
        this.remainingCells--;
        return true;
    }

    public boolean makeRandomMove(TicTacToeSymbol player) {
        //Logic for making random move
        Cell randomFreeCell = getRandomFreeCell();
        randomFreeCell.setOccupant(player);
        this.remainingCells--;
        return true;
    }

    public void printBoardStatus() {
        StringBuilder board = new StringBuilder();
        for(int i = 0; i<this.boardSize; i++) {
            board.append("|");
            for(int j = 0; j<this.boardSize; j++) {
                board.append(this.cells[i][j].getOccupant().toString());
                board.append("|");
            }
            board.append("\n");
        }

        System.out.println(board.toString());
    }

    public TicTacToeSymbol evaluateWinner() {
        //Each row, column
        //First diagonal
        //Second diagonal
        for(int i = 0; i<this.boardSize; i++) {
            for(int j = 1; j<this.boardSize; j++) {
                if(this.cells[i][j].getOccupant() != this.cells[i][j-1].getOccupant())
                    break;

                if(j == this.boardSize-1)
                    return this.cells[i][j].getOccupant();
            }
        }

        for(int j = 0; j< this.boardSize; j++) {
            for(int i = 1; i<this.boardSize; i++) {
                if(this.cells[i][j].getOccupant() != this.cells[i-1][j].getOccupant())
                    break;

                if(i == this.boardSize-1)
                    return this.cells[i][j].getOccupant();
            }
        }

        for(int i = 1; i<this.boardSize; i++) {
            if(this.cells[i][i].getOccupant() != this.cells[i-1][i-1].getOccupant())
                break;

            if(i == this.boardSize-1)
                return this.cells[i][i].getOccupant();
        }

        for(int i = 1; i<this.boardSize; i++) {
            if(this.cells[i][this.boardSize-i-1].getOccupant() == this.cells[i-1][this.boardSize - i].getOccupant())
                break;

            if(i == this.boardSize-1)
                return this.cells[i][this.boardSize-1-i].getOccupant();
        }

        return null;
    }

    public boolean allCellsOccupied() {
        return this.remainingCells == 0;
    }

    private Cell getRandomFreeCell() {
        List<Cell> freeCells = new ArrayList<>();
        for(int i = 0; i<this.boardSize; i++) {
            for(int j = 0; j<this.boardSize; j++) {
                if(this.cells[i][j].getOccupant() == null)
                    freeCells.add(this.cells[i][j]);
            }
        }

        int randomIdx = new Random().nextInt(freeCells.size());
        return freeCells.get(randomIdx);
    }
}
