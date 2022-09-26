package com.lowleveldesign.projects.tictactoe;

public class Player {
    private User user;
    private TicTacToeSymbol ticTacToeSymbol;

    public Player(User user, TicTacToeSymbol ticTacToeSymbol) {
        this.user = user;
        this.ticTacToeSymbol = ticTacToeSymbol;
    }

    public User getUser() {
        return user;
    }

    public TicTacToeSymbol getTicTacToeSymbol() {
        return ticTacToeSymbol;
    }
}
