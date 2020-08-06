package com.uag.cesar.solis;

import static com.uag.cesar.solis.BoardUtils.*;

public class Board {
  private static final int BOARD_SIZE = 8;
  private int[][] boardState;

  public Board() {
    this.initBoard();
  }

  private void initBoard() {
    this.boardState = new int[BOARD_SIZE][BOARD_SIZE];
    final int middle = (BOARD_SIZE / 2) - 1;
    // put initial whites
    this.boardState[middle][middle] = Disc.WHITE.getDiscIntValue();
    this.boardState[middle + 1][middle + 1] = Disc.WHITE.getDiscIntValue();
    // put initial blacks
    this.boardState[middle][middle + 1] = Disc.BLACK.getDiscIntValue();
    this.boardState[middle + 1][middle] = Disc.BLACK.getDiscIntValue();
    // TODO: add reference to starting position image
  }

  public int[][] getBoardState() {
    return this.boardState;
  }

  private boolean isValidMove(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    return isEmptyCell(boardRow, boardColumn, this.boardState)
        && isAdjacentToEnemy(disc, boardRow, boardColumn, this.boardState)
        && isClinchMove(disc, boardRow, boardColumn, this.boardState);
  }


  public void moveDisc(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    if (!isValidMove(disc, boardRow, boardColumn)) {
      throw new IllegalArgumentException("("  + boardRow + "," + boardColumn + ") is an invalid disc move");
    }
    // valid move, flip enemy discs
    flipEnemies(disc, boardRow, boardColumn);
    this.boardState[boardRow.getBoardRowIntValue()][boardColumn.getBoardColumnIntValue()] = disc.getDiscIntValue();
  }

  private void flipLeftEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    final int discIntValue = disc.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean allyFound = false;
    int columnIndex = boardColumnIntValue - 1;

    do {
      if (boardState[boardRowIntValue][columnIndex] == discIntValue) {
        allyFound = true;
      } else {
        boardState[boardRowIntValue][columnIndex] = discIntValue;
        columnIndex--;
      }
    } while (!allyFound && columnIndex >= 0);
  }

  private void flipRightEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    final int discIntValue = disc.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean allyFound = false;
    int columnIndex = boardColumnIntValue + 1;

    do {
      if (boardState[boardRowIntValue][columnIndex] == discIntValue) {
        allyFound = true;
      } else {
        boardState[boardRowIntValue][columnIndex] = discIntValue;
        columnIndex++;
      }
    } while (!allyFound && columnIndex < BOARD_SIZE);
  }

  private void flipUpEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    final int discIntValue = disc.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean allyFound = false;
    int rowIndex = boardRowIntValue - 1;

    do {
      if (boardState[rowIndex][boardColumnIntValue] == discIntValue) {
        allyFound = true;
      } else {
        boardState[rowIndex][boardColumnIntValue] = discIntValue;
        rowIndex--;
      }
    } while (!allyFound && rowIndex >= 0);
  }

  private void flipDownEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    final int discIntValue = disc.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean allyFound = false;
    int rowIndex = boardRowIntValue + 1;

    do {
      if (boardState[rowIndex][boardColumnIntValue] == discIntValue) {
        allyFound = true;
      } else {
        boardState[rowIndex][boardColumnIntValue] = discIntValue;
        rowIndex++;
      }
    } while (!allyFound && rowIndex < BOARD_SIZE);
  }

  private void flipUpLeftEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    final int discIntValue = disc.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean allyFound = false;
    int rowIndex = boardRowIntValue - 1;
    int columnIndex = boardColumnIntValue - 1;

    do {
      if (boardState[rowIndex][columnIndex] == discIntValue) {
        allyFound = true;
      } else {
        boardState[rowIndex][columnIndex] = discIntValue;
        rowIndex--;
        columnIndex--;
      }
    } while (!allyFound && rowIndex >= 0 && columnIndex >= 0);
  }

  private void flipDownLeftEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    final int discIntValue = disc.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean allyFound = false;
    int rowIndex = boardRowIntValue + 1;
    int columnIndex = boardColumnIntValue - 1;

    do {
      if (boardState[rowIndex][columnIndex] == discIntValue) {
        allyFound = true;
      } else {
        boardState[rowIndex][columnIndex] = discIntValue;
        rowIndex++;
        columnIndex--;
      }
    } while (!allyFound && rowIndex < BOARD_SIZE && columnIndex >= 0);
  }

  private void flipUpRightEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    final int discIntValue = disc.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean allyFound = false;
    int rowIndex = boardRowIntValue - 1;
    int columnIndex = boardColumnIntValue + 1;

    do {
      if (boardState[rowIndex][columnIndex] == discIntValue) {
        allyFound = true;
      } else {
        boardState[rowIndex][columnIndex] = discIntValue;
        rowIndex--;
        columnIndex++;
      }
    } while (!allyFound && rowIndex >= 0 && columnIndex < BOARD_SIZE);
  }

  private void flipDownRightEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    final int discIntValue = disc.getDiscIntValue();
    final int boardRowIntValue = boardRow.getBoardRowIntValue();
    final int boardColumnIntValue = boardColumn.getBoardColumnIntValue();
    boolean allyFound = false;
    int rowIndex = boardRowIntValue + 1;
    int columnIndex = boardColumnIntValue + 1;

    do {
      if (boardState[rowIndex][columnIndex] == discIntValue) {
        allyFound = true;
      } else {
        boardState[rowIndex][columnIndex] = discIntValue;
        rowIndex++;
        columnIndex++;
      }
    } while (!allyFound && rowIndex < BOARD_SIZE && columnIndex < BOARD_SIZE);
  }

  private void flipEnemies(
      Disc disc,
      BoardRow boardRow,
      BoardColumn boardColumn
  ) {
    // flip left
    if (isLeftClinchMove(disc, boardRow, boardColumn, this.boardState)) {
      flipLeftEnemies(disc, boardRow, boardColumn);
    }

    // flip right
    if (isRightClinchMove(disc, boardRow, boardColumn, this.boardState)) {
      flipRightEnemies(disc, boardRow, boardColumn);
    }

    // flip up
    if (isUpClinchMove(disc, boardRow, boardColumn, this.boardState)) {
      flipUpEnemies(disc, boardRow, boardColumn);
    }

    // flip down
    if (isDownClinchMove(disc, boardRow, boardColumn, this.boardState)) {
      flipDownEnemies(disc, boardRow, boardColumn);
    }

    // flip up left
    if (isUpLeftDiagonalClinch(disc, boardRow, boardColumn, this.boardState)) {
      flipUpLeftEnemies(disc, boardRow, boardColumn);
    }

    // flip down left
    if (isDownLeftClinchMove(disc, boardRow, boardColumn, this.boardState)) {
      flipDownLeftEnemies(disc, boardRow, boardColumn);
    }

    // flip up right
    if (isUpRightClinchMove(disc, boardRow, boardColumn, this.boardState)) {
      flipUpRightEnemies(disc, boardRow, boardColumn);
    }

    // flip down right
    if (isDownRightClinchMove(disc, boardRow, boardColumn, this.boardState)) {
      flipDownRightEnemies(disc, boardRow, boardColumn);
    }
  }

  public boolean isFinalState() {
    // TODO: implement
    return false;
  }
}
