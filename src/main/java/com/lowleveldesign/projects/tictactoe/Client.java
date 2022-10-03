package com.lowleveldesign.projects.tictactoe;

import java.io.IOException;

public class Client {
    public static void main(String[] args)throws IOException {
        //Users
        User myUser = new User("Pratyush", "Prateek", "ABCD@gmail.com");
        User secondUser = new User("Windows", "PC", "windows@windows.com");

        //Players
        Player first = myUser.getTicTacToePlayer(Piece.X);
        Player second = secondUser.getTicTacToePlayer(Piece.O);

        //Game
        Game game = new Game(3, first, second);
        game.makeMove(1,1);
        game.makeMove(1,2);
        game.makeMove(2,2);
        game.makeMove(3,3);
        game.makeMove(2,1);
        game.makeMove(1,3);
        game.makeMove(3,1);
    }
}
