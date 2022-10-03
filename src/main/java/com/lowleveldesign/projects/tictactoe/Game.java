package com.lowleveldesign.projects.tictactoe;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Queue<Player> players;
    private Board board;
    private Player winner;
    private GameStatus gameStatus;
    public Game(int boardSize, Player player1, Player player2) {
        this.players = new LinkedList<>();
        this.board = new Board(boardSize);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.players.add(player1);
        this.players.add(player2);
    }

    public void makeMove(int row, int column) {
        if(this.gameStatus == GameStatus.FINISHED) {
            System.out.println("This game has already been won by: " + this.winner.toString());
            return;
        }

        if(this.gameStatus == GameStatus.DRAW) {
            System.out.println("This game has been drawed");
            return;
        }

        Player currentPlayer = this.players.peek();
        boolean isMoveValid = this.board.makeMove(currentPlayer.getPiece(), row-1, column-1);

        if(!isMoveValid) {
            System.out.println("This move is not valid.");
            return;
        }

        if(this.board.allCellsOccupied()) {
            this.gameStatus = GameStatus.DRAW;
            System.out.println("Game draw");
            return;
        }

        if(this.board.checkWinner(currentPlayer.getPiece(),row-1, column-1)) {
            this.winner = currentPlayer;
            this.gameStatus = GameStatus.FINISHED;
            System.out.println("Game over, the winner is: " + this.winner.toString());
            this.board.printBoardStatus();
            return;
        }

        this.players.poll();
        this.players.add(currentPlayer);
        this.board.printBoardStatus();
        return;
    }
}
