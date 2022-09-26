package com.lowleveldesign.projects.tictactoe;

public class User {
    private String firstName;
    private String lastName;
    private String userId;

    public User(String firstName, String lastName, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

    public Player getTicTacToePlayer(TicTacToeSymbol ticTacToeSymbol) {
        return new Player(this, ticTacToeSymbol);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
