package com.lowleveldesign.projects.tictactoe;

public abstract class Game {
    protected Player firstPlayer;
    protected Player secondPlayer;
    protected TicTacToeSymbol firstPlayerSymbol;
    protected TicTacToeSymbol secondPlayerSymbol;
    protected TicTacToeSymbol currentPlayerSymbol;
    protected TicTacToeSymbol winnerSymbol;
    protected GameStatus gameStatus;
    protected Board board;
    public Game(Player firstPlayer, Player secondPlayer, int size) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstPlayerSymbol = firstPlayer.getTicTacToeSymbol();
        this.secondPlayerSymbol = secondPlayer.getTicTacToeSymbol();
        this.board = new Board(size);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.currentPlayerSymbol = this.firstPlayerSymbol;
    }

    public abstract void makeMove(int row, int col);

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        if(this.winnerSymbol == null) {
            System.out.println("No one has won this game");
            return null;
        }

        if(this.winnerSymbol.equals(this.firstPlayerSymbol))
            return this.firstPlayer;

        if(this.winnerSymbol.equals(this.secondPlayerSymbol))
            return this.secondPlayer;

        return null;
    }
}
