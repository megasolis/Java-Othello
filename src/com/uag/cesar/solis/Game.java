package com.uag.cesar.solis;

import java.util.List;
import java.util.Scanner;

public class Game {
  private static final String EXIT_OPTION = "exit";
  private Board board;
  private boolean multiplayer;

  public Game() {
    this.board = new Board();
    this.multiplayer = true;
  }

  public Game(boolean multiplayer) {
    this.board = new Board();
    this.multiplayer = multiplayer;
  }

  public void start() {
    System.out.println("START!!!");


    if (this.multiplayer) {
      startMultiplayer();
    } else {
      startSinglePlayer();
    }
  }

  private void startSinglePlayer() {
    final Scanner scanner = new Scanner(System.in);
    String input;
    String[] inputParts;
    Disc playingDisc;
    BoardRow boardRow;
    BoardColumn boardColumn;
    boolean gameFinished = false; BoardUtils.isGameFinished(this.board.getBoardState());
    int playsCounter = 0;
    List<Move> possibleMoves;
    Move computerMove;

    while (!gameFinished) {
      BoardUtils.printBoardState(this.board.getBoardState());

      if (playsCounter % 2 == 0) {
        // whites
        possibleMoves = BoardUtils.getPossibleMoves(Disc.WHITE, this.board.getBoardState());

        if (possibleMoves.isEmpty()) {
          System.out.println("Whites can't perform any movement, skipping...");
          playsCounter++;
          continue;
        }
        System.out.print("Whites move (ROW,COLUMN), type 'exit' to leave:");
        playingDisc = Disc.WHITE;

        input = scanner.nextLine();

        if (input.equals(EXIT_OPTION)) {
          break;
        }
        // split input
        inputParts = input.split(",");

        if (inputParts.length < 2) {
          System.out.println("Wrong input, try again...");
          continue;
        }
        boardRow = BoardRow.getBoardRowForStringValue(inputParts[0]);

        if (boardRow == null) {
          System.out.println("Wrong input, try again...");
          continue;
        }
        boardColumn = BoardColumn.getBoardColumnForStringValue(inputParts[1]);

        if (boardColumn == null) {
          System.out.println("Wrong input, try again...");
          continue;
        }

        if (!BoardUtils.isValidMove(playingDisc, boardRow, boardColumn, this.board.getBoardState())) {
          System.out.println("Invalid move, try again...");
          continue;
        }

        // make the move
        this.board.moveDisc(playingDisc, boardRow, boardColumn);
        playsCounter++;
      } else {
        System.out.println("Computer turn...");
        // blacks
        possibleMoves = BoardUtils.getPossibleMoves(Disc.BLACK, this.board.getBoardState());

        if (possibleMoves.isEmpty()) {
          System.out.println("Blacks can't perform any movement, skipping...");
          playsCounter++;
          continue;
        }
        // get the best move for blacks
        computerMove = MiniMax.computeMinMax(this.board.getBoardState());

        if (computerMove == null) {
          System.out.println("Blacks could not decide for any movement, skipping...");
          continue;
        }
        System.out.println("Moving: " + computerMove);
        this.board.moveDisc(Disc.BLACK, computerMove.getBoardRow(), computerMove.getBoardColumn());
        playsCounter++;
      }
      gameFinished = BoardUtils.isGameFinished(this.board.getBoardState());
    }

    if (gameFinished) {
      BoardUtils.printBoardState(this.board.getBoardState());
      BoardUtils.printWinner(this.board.getBoardState());
    }
  }

  private void startMultiplayer() {
    final Scanner scanner = new Scanner(System.in);
    String input;
    String[] inputParts;
    Disc playingDisc;
    BoardRow boardRow;
    BoardColumn boardColumn;
    boolean gameFinished = false; BoardUtils.isGameFinished(this.board.getBoardState());
    int playsCounter = 0;
    List<Move> possibleMoves;

    while (!gameFinished) {
      BoardUtils.printBoardState(this.board.getBoardState());

      if (playsCounter % 2 == 0) {
        // whites
        possibleMoves = BoardUtils.getPossibleMoves(Disc.WHITE, this.board.getBoardState());

        if (possibleMoves.isEmpty()) {
          System.out.println("Whites can't perform any movement, skipping...");
          continue;
        }
        System.out.print("Whites move (ROW,COLUMN), type 'exit' to leave:");
        playingDisc = Disc.WHITE;
      } else {
        // blacks
        possibleMoves = BoardUtils.getPossibleMoves(Disc.BLACK, this.board.getBoardState());

        if (possibleMoves.isEmpty()) {
          System.out.println("Blacks can't perform any movement, skipping...");
          continue;
        }
        System.out.print("Blacks move (ROW,COLUMN), type 'exit' to leave:");
        playingDisc = Disc.BLACK;
      }


      input = scanner.nextLine();

      if (input.equals(EXIT_OPTION)) {
        break;
      }
      // split input
      inputParts = input.split(",");

      if (inputParts.length < 2) {
        System.out.println("Wrong input, try again...");
        continue;
      }
      boardRow = BoardRow.getBoardRowForStringValue(inputParts[0]);

      if (boardRow == null) {
        System.out.println("Wrong input, try again...");
        continue;
      }
      boardColumn = BoardColumn.getBoardColumnForStringValue(inputParts[1]);

      if (boardColumn == null) {
        System.out.println("Wrong input, try again...");
        continue;
      }

      if (!BoardUtils.isValidMove(playingDisc, boardRow, boardColumn, this.board.getBoardState())) {
        System.out.println("Invalid move, try again...");
        continue;
      }

      // make the move
      this.board.moveDisc(playingDisc, boardRow, boardColumn);
      playsCounter++;
      gameFinished = BoardUtils.isGameFinished(this.board.getBoardState());
    }

    if (gameFinished) {
      BoardUtils.printBoardState(this.board.getBoardState());
      BoardUtils.printWinner(this.board.getBoardState());
    }
  }
}
