package com.uag.cesar.solis;

import java.util.Arrays;
import java.util.List;

public class MiniMax {
  private static final int PLY_DEPTH = 4;
  private static final float MIN_POSSIBLE_VALUE = 0.0F;
  private static final float MAX_POSSIBLE_VALUE = 10.0F;

  private static float evaluateMax(int[][] boardState) {
    final int[][] weights = new int[][] {
        {0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {0, 120, -20,  20,   5,   5,  20, -20, 120,   0},
        {0, -20, -40,  -5,  -5,  -5,  -5, -40, -20,   0},
        {0,  20,  -5,  15,   3,   3,  15,  -5,  20,   0},
        {0,   5,  -5,   3,   3,   3,   3,  -5,   5,   0},
        {0,   5,  -5,   3,   3,   3,   3,  -5,   5,   0},
        {0,  20,  -5,  15,   3,   3,  15,  -5,  20,   0},
        {0, -20, -40,  -5,  -5,  -5,  -5, -40, -20,   0},
        {0, 120, -20,  20,   5,   5,  20, -20, 120,   0},
        {0,   0,   0,   0,   0,   0,   0,   0,   0,   0}
    };

    int result = 0;
    for(int i=0; i < boardState.length; i++) {
      for(int j=0; j < boardState[i].length; j++) {
        if (boardState[i][j] == Disc.WHITE.getDiscIntValue()){
          result += weights[i][j];
        }
        else if (boardState[i][j] != 0){
          result -= weights[i][j];
        }
      }
    }
    return result;
  }

  private static float evaluateMin(int[][] boardState) {
    final int[][] weights = new int[][] {
        {0,   0,   0,   0,   0,   0,   0,   0,   0,   0},
        {0, 120, -20,  20,   5,   5,  20, -20, 120,   0},
        {0, -20, -40,  -5,  -5,  -5,  -5, -40, -20,   0},
        {0,  20,  -5,  15,   3,   3,  15,  -5,  20,   0},
        {0,   5,  -5,   3,   3,   3,   3,  -5,   5,   0},
        {0,   5,  -5,   3,   3,   3,   3,  -5,   5,   0},
        {0,  20,  -5,  15,   3,   3,  15,  -5,  20,   0},
        {0, -20, -40,  -5,  -5,  -5,  -5, -40, -20,   0},
        {0, 120, -20,  20,   5,   5,  20, -20, 120,   0},
        {0,   0,   0,   0,   0,   0,   0,   0,   0,   0}
    };
    int result = 0;

    for(int i=0; i < boardState.length; i++) {
      for(int j=0; j < boardState[i].length; j++) {
        if (boardState[i][j] == Disc.BLACK.getDiscIntValue()){
          result += weights[i][j];
        }
        else if (boardState[i][j] != 0){
          result -= weights[i][j];
        }
      }
    }
    return result;
  }

  private static int[][] cloneBoardState(int[][] boardState) {
    return Arrays.stream(boardState).map(int[]::clone).toArray(int[][]::new);
  }

  public static Move computeMinMax(int[][] boardState) {
    // we are assuming that there will always be possible moves
    final List<Move> moves = BoardUtils.getPossibleMoves(Disc.BLACK, boardState);
    float max = Float.MIN_VALUE;
    float moveMax;
    Move bestMove = null;

    for (Move m : moves) {
      // first, set the move in the board state
      int[][] clonedBoardState = cloneBoardState(boardState);
      clonedBoardState[m.getBoardRow().getBoardRowIntValue()][m.getBoardColumn().getBoardColumnIntValue()]
          = Disc.BLACK.getDiscIntValue();
      moveMax = computeMax(clonedBoardState, 0);

      if (max == Float.MIN_VALUE) {
        max = moveMax;
        bestMove = m;
      } else if (moveMax > max) {
        max = moveMax;
        bestMove = m;
      }
    }

    return bestMove;
  }

  private static float computeMax(int[][] boardState, int depth) {
    if (depth == PLY_DEPTH) {
      // evaluate this move and return as this is a leaf node
      return evaluateMax(boardState);
    }
    // get possible moves for max in this state
    // at this point
    float max = Float.MIN_VALUE;
    final List<Move> moves = BoardUtils.getPossibleMoves(Disc.BLACK, boardState);

    if (moves.isEmpty()) {
      // there are no moves left for this state
      // return the evaluation
      return evaluateMax(boardState);
    }
    depth++;
    float moveMax;

    for (Move m : moves) {
      boardState[m.getBoardRow().getBoardRowIntValue()][m.getBoardColumn().getBoardColumnIntValue()] =
          Disc.BLACK.getDiscIntValue();
      moveMax = computeMin(boardState, depth);

      if (max == Float.MIN_VALUE) {
        // first value
        max = moveMax;
      } else if (moveMax > max) {
        max = moveMax;
      }
    }

    return max;
  }

  private static float computeMin(int[][] boardState, int depth) {
    if (depth == PLY_DEPTH) {
      // evaluate
      return evaluateMin(boardState);
    }
    // get possible moves for min in this state
    // we are assuming that there will always be possible moves
    // at this point
    float min = Float.MAX_VALUE;
    final List<Move> moves = BoardUtils.getPossibleMoves(Disc.WHITE, boardState);

    if (moves.isEmpty()) {
      // there are no moves left for this state
      // return the evaluation
      return evaluateMin(boardState);
    }
    depth++;
    float moveMin;

    for (Move m : moves) {
      boardState[m.getBoardRow().getBoardRowIntValue()][m.getBoardColumn().getBoardColumnIntValue()] =
          Disc.WHITE.getDiscIntValue();
      moveMin = computeMax(boardState, depth);

      if (min == Float.MAX_VALUE) {
        // first value
        min = moveMin;
      } else if (moveMin < min) {
        min = moveMin;
      }
    }

    return min;
  }
}
