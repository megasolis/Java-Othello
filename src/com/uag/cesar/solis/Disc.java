package com.uag.cesar.solis;

public enum Disc {
  EMPTY(0),
  WHITE(1),
  BLACK(2);

  private int discIntValue;

  Disc(int discIntValue) {
    this.discIntValue = discIntValue;
  }

  public int getDiscIntValue() {
    return this.discIntValue;
  }
}
