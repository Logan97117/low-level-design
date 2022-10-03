package com.lowleveldesign.projects.tictactoe;

public class Player {
    private User user;
    private Piece piece;

    public Player(User user, Piece piece) {
        this.user = user;
        this.piece = piece;
    }

    public User getUser() {
        return user;
    }

    public Piece getPiece() {
        return piece;
    }
}
