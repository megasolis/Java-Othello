package com.uag.cesar.solis;

import java.util.List;

public class Main {

    public static void main(String[] args) {
      /*final Board board = new Board();
      System.out.println("Starting board...");
      BoardUtils.printBoardState(board.getBoardState());
      //board.moveDisc(Disc.WHITE,
      //    BoardRow.getBoardRowForStringValue("3"),
      //    BoardColumn.getBoardColumnForStringValue("E"));
      //BoardUtils.printBoardState(board.getBoardState());
      final List<int[][]> possibleMoves = BoardUtils.getPossibleMoves(
          Disc.BLACK,
          board.getBoardState()
      );

      for (int[][] move : possibleMoves) {
        System.out.println("Possible move...");
        BoardUtils.printBoardState(move);
      }*/
      final Game game = new Game(false);
      game.start();
    }
}
