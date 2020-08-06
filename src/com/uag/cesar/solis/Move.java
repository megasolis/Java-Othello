package com.uag.cesar.solis;

public class Move {
  private BoardRow boardRow;
  private BoardColumn boardColumn;
  private float minValue;
  private float maxValue;

  public Move(BoardRow boardRow, BoardColumn boardColumn) {
    this.boardRow = boardRow;
    this.boardColumn = boardColumn;
    this.minValue = Float.MAX_VALUE;
    this.maxValue = Float.MIN_VALUE;
  }

  public BoardRow getBoardRow() {
    return this.boardRow;
  }

  public BoardColumn getBoardColumn() {
    return this.boardColumn;
  }

  public void setMinValue(float minValue) {
    this.minValue = minValue;
  }

  public float getMinValue() {
    return this.minValue;
  }

  public void setMaxMalue(float maxValue) {
    this.maxValue = maxValue;
  }

  public float getMaxValue() {
    return this.maxValue;
  }

  @Override
  public String toString() {
    return this.boardRow + "," + this.boardColumn;
  }
}
