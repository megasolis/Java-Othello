package com.uag.cesar.solis;

public enum BoardRow {
  _1(0),
  _2(1),
  _3(2),
  _4(3),
  _5(4),
  _6(5),
  _7(6),
  _8(7);

  private int boardRowIntValue;

  BoardRow(int boardRowIntValue) {
    this.boardRowIntValue = boardRowIntValue;
  }

  public int getBoardRowIntValue() {
    return this.boardRowIntValue;
  }

  public static BoardRow getBoardRowForIntValue(int boardRowIntValue) {
    switch (boardRowIntValue) {
      case 0:
        return _1;

      case 1:
        return _2;

      case 2:
        return _3;

      case 3:
        return _4;

      case 4:
        return _5;

      case 5:
        return _6;

      case 6:
        return _7;

      case 7:
        return _8;
    }

    return null;
  }

  public static BoardRow getBoardRowForStringValue(String boardRowStringValue) {
    switch (boardRowStringValue) {
      case "1":
        return _1;

      case "2":
        return _2;

      case "3":
        return _3;

      case "4":
        return _4;

      case "5":
        return _5;

      case "6":
        return _6;

      case "7":
        return _7;

      case "8":
        return _8;
    }

    return null;
  }

  @Override
  public String toString() {
    switch (this.boardRowIntValue) {
      case 0:
        return "1";

      case 1:
        return "2";

      case 2:
        return "3";

      case 3:
        return "4";

      case 4:
        return "5";

      case 5:
        return "6";

      case 6:
        return "7";

      case 7:
        return "8";
    }

    return super.toString();
  }
}
