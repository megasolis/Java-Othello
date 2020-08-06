package com.uag.cesar.solis;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MiniMax {
  private static final int PLY_DEPTH = 4;
  private static final float MIN_POSSIBLE_VALUE = 0.0F;
  private static final float MAX_POSSIBLE_VALUE = 10.0F;

  private static float evaluateMax(int[][] boardState) {
    // TODO: put real "IA" here
    final Random r = new Random();
    return MIN_POSSIBLE_VALUE + r.nextFloat() * (MAX_POSSIBLE_VALUE - MIN_POSSIBLE_VALUE);
  }

  private static float evaluateMin(int[][] boardState) {
    // TODO: put real "IA" here
    final Random r = new Random();
    return MIN_POSSIBLE_VALUE + r.nextFloat() * (MAX_POSSIBLE_VALUE - MIN_POSSIBLE_VALUE);
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

      if (moveMax > max) {
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

      if (moveMax > max) {
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

      if (moveMin < min) {
        min = moveMin;
      }
    }

    return min;
  }
}
