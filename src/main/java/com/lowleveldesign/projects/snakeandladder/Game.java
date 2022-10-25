package com.lowleveldesign.projects.snakeandladder;

import com.lowleveldesign.projects.snakeandladder.enums.GameStatus;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private Queue<Player> players;
    private Player winner;
    private Board board;
    private GameStatus status;
    public Game(int size, int snakes, int ladders, User firstUser, User secondUser) {
        this.board = new Board(size, snakes, ladders);
        this.players = new LinkedList<>();
        this.players.add(new Player(firstUser));
        this.players.add(new Player(secondUser));
        this.status = GameStatus.IN_PROGRESS;
    }

    public void makeMove() {
        if(this.status == GameStatus.FINISHED) {
            System.out.println("Game is already finished and won by: " + this.winner.getUser().toString());
            return;
        }

        Player currentPlayer = this.players.poll();
        int position = currentPlayer.getPosition();
        int move = Dice.getDiceRoll();
        int newPosition = this.board.makeMove(position, move);
        currentPlayer.setPosition(newPosition);

        if(this.board.isFinished(newPosition)) {
            this.status = GameStatus.FINISHED;
            this.winner = currentPlayer;
            System.out.println("Game finished, winner is: " + this.winner.getUser().toString());
            return;
        }

        this.players.add(currentPlayer);
        return;
    }
}
