package com.lowleveldesign.projects.tictactoe;

public class TwoVTwoGame extends Game{
    public TwoVTwoGame(Player firstPlayer, Player secondPlayer, int size) {
        super(firstPlayer, secondPlayer, size);
    }

    @Override
    public void makeMove(int row, int col) {
        //Check whether the game is already finished or draw
        if(this.gameStatus == GameStatus.FINISHED || this.gameStatus == GameStatus.DRAW) {
            System.out.println("Game has already finished");
            return;
        }

        boolean canMakeMove = this.board.makeMove(this.currentPlayerSymbol, row, col);

        if(!canMakeMove) {
            //If invalid cell
            System.out.println("The cell is already occupied, please make a valid move");
            return;
        }

        this.winnerSymbol = this.board.evaluateWinner();

        if(this.winnerSymbol == null && this.board.allCellsOccupied()) {
            this.gameStatus = GameStatus.DRAW;
            System.out.println("DRAW");
            return;
        }
        else if(this.winnerSymbol != null) {
            this.gameStatus = GameStatus.FINISHED;
            Player winner = this.getWinner();
            System.out.println(winner.toString() + " has won the game");
            return;
        }

        //Swap turns for next move
        this.currentPlayerSymbol = this.firstPlayerSymbol == this.currentPlayerSymbol? this.secondPlayerSymbol: this.firstPlayerSymbol;
        return;
    }
}
