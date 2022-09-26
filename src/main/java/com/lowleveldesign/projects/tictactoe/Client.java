package com.lowleveldesign.projects.tictactoe;

import java.io.IOException;

public class Client {
    public static void main(String[] args)throws IOException {
        //Users
        User myUser = new User("Pratyush", "Prateek", "ABCD@gmail.com");
        User secondUser = new User("Windows", "PC", "windows@windows.com");

        Game tictactoe = new OneVPCGame(myUser.getTicTacToePlayer(TicTacToeSymbol.O), secondUser.getTicTacToePlayer(TicTacToeSymbol.X), 3);
        tictactoe.makeMove(1,1);
        tictactoe.makeMove(3,3);
        tictactoe.makeMove(2,2);
        tictactoe.makeMove(3,1);
    }
}
