package com.uag.cesar.solis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.uag.cesar.solis.Constants.BOARD_SIZE;

public class BoardUtils {

  public static boolean isLeftClinchMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int emptyCellIntValue = Disc.EMPTY.getDiscIntValue();
    final int discIntValue = disc.getDiscIntValue();
    final int enemyDiscIntValue = Disc.WHITE.getDiscIntValue() == discIntValue
        ? Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean enemyFound = false;

    // check left
    for (int j = boardColumnIntValue - 1; j >= 0; j--) {
      if (boardState[boardRowIntValue][j] == enemyDiscIntValue) {
        enemyFound = true;
      } else if (boardState[boardRowIntValue][j] == emptyCellIntValue) {
        // there is an "escape route"
        return false;
      } else if (boardState[boardRowIntValue][j] == discIntValue && !enemyFound) {
        // ally beside
        return false;
      } else if (boardState[boardRowIntValue][j] == discIntValue && enemyFound) {
        // clinched
        return true;
      }
    }

    return false;
  }

  public static boolean isRightClinchMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int emptyCellIntValue = Disc.EMPTY.getDiscIntValue();
    final int discIntValue = disc.getDiscIntValue();
    final int enemyDiscIntValue = Disc.WHITE.getDiscIntValue() == discIntValue
        ? Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean enemyFound = false;

    for (int j = boardColumnIntValue + 1; j < BOARD_SIZE; j++) {
      if (boardState[boardRowIntValue][j] == enemyDiscIntValue) {
        enemyFound = true;
      } else if (boardState[boardRowIntValue][j] == emptyCellIntValue) {
        // there is an "escape route"
        return false;
      } else if (boardState[boardRowIntValue][j] == discIntValue && !enemyFound) {
        // ally beside
        return false;
      } else if (boardState[boardRowIntValue][j] == discIntValue && enemyFound) {
        // clinched
        return true;
      }
    }

    return false;
  }

  public static boolean isUpClinchMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int emptyCellIntValue = Disc.EMPTY.getDiscIntValue();
    final int discIntValue = disc.getDiscIntValue();
    final int enemyDiscIntValue = Disc.WHITE.getDiscIntValue() == discIntValue
        ? Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean enemyFound = false;

    for (int i = boardRowIntValue - 1; i >= 0; i--) {
      if (boardState[i][boardColumnIntValue] == enemyDiscIntValue) {
        enemyFound = true;
      } else if (boardState[i][boardColumnIntValue] == emptyCellIntValue) {
        // there is an "escape route"
        return false;
      } else if (boardState[i][boardColumnIntValue] == discIntValue && !enemyFound) {
        // ally beside
        return false;
      } else if (boardState[i][boardColumnIntValue] == discIntValue && enemyFound) {
        // clinched
        return true;
      }
    }

    return false;
  }

  public static boolean isDownClinchMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int emptyCellIntValue = Disc.EMPTY.getDiscIntValue();
    final int discIntValue = disc.getDiscIntValue();
    final int enemyDiscIntValue = Disc.WHITE.getDiscIntValue() == discIntValue
        ? Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean enemyFound = false;

    for (int i = boardRowIntValue + 1; i < BOARD_SIZE; i++) {
      if (boardState[i][boardColumnIntValue] == enemyDiscIntValue) {
        enemyFound = true;
      } else if (boardState[i][boardColumnIntValue] == emptyCellIntValue) {
        // there is an "escape route"
        return false;
      } else if (boardState[i][boardColumnIntValue] == discIntValue && !enemyFound) {
        // ally beside
        return false;
      } else if (boardState[i][boardColumnIntValue] == discIntValue && enemyFound) {
        // clinched
        return true;
      }
    }

    return false;
  }

  public static boolean isUpLeftDiagonalClinch(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int emptyCellIntValue = Disc.EMPTY.getDiscIntValue();
    final int discIntValue = disc.getDiscIntValue();
    final int enemyDiscIntValue = Disc.WHITE.getDiscIntValue() == discIntValue
        ? Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean enemyFound = false;

    for (int i = boardRowIntValue - 1, j = boardColumnIntValue - 1;
         i >= 0 && j >= 0;
         i--, j--) {
      if (boardState[i][j] == enemyDiscIntValue) {
        enemyFound = true;
      } else if (boardState[i][j] == emptyCellIntValue) {
        // there is an escape route
        return false;
      } else if (boardState[i][j] == discIntValue && !enemyFound) {
        // ally beside
        return false;
      } else if (boardState[i][j] == discIntValue && enemyFound) {
        // clinched
        return true;
      }
    }

    return false;
  }

  public static boolean isDownLeftClinchMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int emptyCellIntValue = Disc.EMPTY.getDiscIntValue();
    final int discIntValue = disc.getDiscIntValue();
    final int enemyDiscIntValue = Disc.WHITE.getDiscIntValue() == discIntValue
        ? Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean enemyFound = false;

    for (int i = boardRowIntValue + 1, j = boardColumnIntValue - 1;
         i < BOARD_SIZE && j >= 0;
         i++, j--) {
      if (boardState[i][j] == enemyDiscIntValue) {
        enemyFound = true;
      } else if (boardState[i][j] == emptyCellIntValue) {
        // there is an escape route
        return false;
      } else if (boardState[i][j] == discIntValue && !enemyFound) {
        // ally beside
        return false;
      } else if (boardState[i][j] == discIntValue && enemyFound) {
        // clinched
        return true;
      }
    }

    return false;
  }

  public static boolean isDownRightClinchMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int emptyCellIntValue = Disc.EMPTY.getDiscIntValue();
    final int discIntValue = disc.getDiscIntValue();
    final int enemyDiscIntValue = Disc.WHITE.getDiscIntValue() == discIntValue
        ? Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean enemyFound = false;

    for (int i = boardRowIntValue + 1, j = boardColumnIntValue + 1;
         i < BOARD_SIZE && j < BOARD_SIZE;
         i++, j++) {
      if (boardState[i][j] == enemyDiscIntValue) {
        enemyFound = true;
      } else if (boardState[i][j] == emptyCellIntValue) {
        // there is an escape route
        return false;
      } else if (boardState[i][j] == discIntValue && !enemyFound) {
        // ally beside
        return false;
      } else if (boardState[i][j] == discIntValue && enemyFound) {
        // clinched
        return true;
      }
    }

    return false;
  }

  public static boolean isUpRightClinchMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int emptyCellIntValue = Disc.EMPTY.getDiscIntValue();
    final int discIntValue = disc.getDiscIntValue();
    final int enemyDiscIntValue = Disc.WHITE.getDiscIntValue() == discIntValue
        ? Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean enemyFound = false;

    for (int i = boardRowIntValue - 1, j = boardColumnIntValue + 1;
         i >= 0 && j < BOARD_SIZE;
         i--, j++) {
      if (boardState[i][j] == enemyDiscIntValue) {
        enemyFound = true;
      } else if (boardState[i][j] == emptyCellIntValue) {
        // there is an escape route
        return false;
      } else if (boardState[i][j] == discIntValue && !enemyFound) {
        // ally beside
        return false;
      } else if (boardState[i][j] == discIntValue && enemyFound) {
        // clinched
        return true;
      }
    }

    return false;
  }

  public static boolean isClinchMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    // check left
    if (isLeftClinchMove(disc, boardRow, boardColumn, boardState)) {
      return true;
    }

    // check right
    if (isRightClinchMove(disc, boardRow, boardColumn, boardState)) {
      return true;
    }

    // check up
    if (isUpClinchMove(disc, boardRow, boardColumn, boardState)) {
      return true;
    }

    // check down
    if (isDownClinchMove(disc, boardRow, boardColumn, boardState)) {
      return true;
    }

    // check up-left diagonal
    if (isUpLeftDiagonalClinch(disc, boardRow, boardColumn, boardState)) {
      return true;
    }

    // check down-left diagonal
    if (isDownLeftClinchMove(disc, boardRow, boardColumn, boardState)) {
      return true;
    }

    // check up-right diagonal
    if (isUpRightClinchMove(disc, boardRow, boardColumn, boardState)) {
      return true;
    }

    // check down-right diagonal
    if (isDownRightClinchMove(disc, boardRow, boardColumn, boardState)) {
      return true;
    }

    return false;
  }

  public static boolean isAdjacentToEnemy(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    final int enemyDiscIntValue = (disc == Disc.WHITE) ?
        Disc.BLACK.getDiscIntValue() : Disc.WHITE.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    // check left
    final int leftPosition = boardColumnIntValue - 1;

    if ((leftPosition >= 0)
        && (boardState[boardRowIntValue][leftPosition] == enemyDiscIntValue)) {
      return true;
    }
    // check right
    final int rightPosition = boardColumnIntValue + 1;

    if ((rightPosition < BOARD_SIZE)
        && (boardState[boardRowIntValue][rightPosition] == enemyDiscIntValue)) {
      return true;
    }
    // check up
    final int upPosition = boardRowIntValue - 1;

    if ((upPosition >= 0)
        && (boardState[upPosition][boardColumnIntValue] == enemyDiscIntValue)) {
      return true;
    }
    // check down
    final int downPosition = boardRowIntValue + 1;

    if ((downPosition < BOARD_SIZE)
        && (boardState[downPosition][boardColumnIntValue] == enemyDiscIntValue)) {
      return true;
    }
    // check up-left diagonal
    if (upPosition >= 0 && leftPosition >= 0 && boardState[upPosition][leftPosition] == enemyDiscIntValue) {
      return true;
    }

    // check up-right diagonal
    if (upPosition >= 0 && rightPosition < BOARD_SIZE && boardState[upPosition][rightPosition] == enemyDiscIntValue) {
      return true;
    }

    // check down-left diagonal
    if (downPosition < BOARD_SIZE && leftPosition >= 0 && boardState[downPosition][leftPosition] == enemyDiscIntValue) {
      return true;
    }

    // check down right diagonal
    if (downPosition < BOARD_SIZE && rightPosition < BOARD_SIZE && boardState[downPosition][rightPosition] == enemyDiscIntValue) {
      return true;
    }

    return false;
  }

  public static boolean isEmptyCell(
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    return boardState[boardRow.getBoardRowIntValue()][boardColumn.getBoardColumnIntValue()] == 0;
  }

  public static boolean isValidMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn,
      int[][] boardState
  ) {
    return isEmptyCell(boardRow, boardColumn, boardState)
        && isAdjacentToEnemy(disc, boardRow, boardColumn, boardState)
        && isClinchMove(disc, boardRow, boardColumn, boardState);
  }

  public static List<Move> getPossibleMoves(
      Disc movingDisc,
      int[][] boardState
  ) {
    if (movingDisc == Disc.EMPTY) {
      throw new IllegalArgumentException("can't get possible moves for empty disc");
    }
    final List<Move> result = new ArrayList<>();
    // just iterate over the board state checking for every empty cell
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (boardState[i][j] != Disc.EMPTY.getDiscIntValue()) {
          // skip if this is not an empty cell
          continue;
        }

        if (isValidMove(
            movingDisc,
            BoardRow.getBoardRowForIntValue(i),
            BoardColumn.getBoardColumnForIntValue(j),
            boardState)) {
          // create a copy of the board state
          result.add(new Move(BoardRow.getBoardRowForIntValue(i),
              BoardColumn.getBoardColumnForIntValue(j)));
        }
      }
    }

    return result;
  }

  public static void printBoardState(int[][] boardState) {
    for (int i = 0; i < BOARD_SIZE; i++) {
      // print columns
      System.out.print(String.format(" %3s", BoardColumn.getBoardColumnForIntValue(i)));
    }
    System.out.println();

    for (int i = 0; i < BOARD_SIZE; i++) {
      // print rows
      System.out.print(String.format("%d", i + 1));

      // print discs
      for (int j = 0; j < BOARD_SIZE; j++) {
        System.out.print(String.format("| %s ", boardState[i][j]
            == Disc.EMPTY.getDiscIntValue() ? " "
            : boardState[i][j] == Disc.WHITE.getDiscIntValue() ? "O" : "X"));
      }
      System.out.println();
    }
  }

  public static boolean isGameFinished(int[][] boardState) {
    // game is over if no more moves can be performed
    final List<Move> whiteMoves = getPossibleMoves(Disc.WHITE, boardState);
    final List<Move> blackMoves = getPossibleMoves(Disc.BLACK, boardState);

    return whiteMoves.isEmpty() && blackMoves.isEmpty();
  }

  public static void printWinner(int[][] boardState) {
    int whitesCounter = 0;
    int blacksCounter = 0;

    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if (boardState[i][j] == Disc.WHITE.getDiscIntValue()) {
          whitesCounter++;
        }

        if (boardState[i][j] == Disc.BLACK.getDiscIntValue()) {
          blacksCounter++;
        }
      }
    }

    if (whitesCounter == blacksCounter) {
      System.out.println("It's a tie!!!");
      return;
    }
    System.out.println(String.format("The winner is %s, with %d discs!!!",
        whitesCounter > blacksCounter ? "WHITES" : "BLACKS",
        whitesCounter > blacksCounter ? whitesCounter : blacksCounter));
  }
}
