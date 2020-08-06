package com.uag.cesar.solis;

public enum BoardColumn {
  _A(0),
  _B(1),
  _C(2),
  _D(3),
  _E(4),
  _F(5),
  _G(6),
  _H(7);

  private int boardColumnIntValue;

  BoardColumn(int boardColumnIntValue) {
    this.boardColumnIntValue = boardColumnIntValue;
  }

  public int getBoardColumnIntValue() {
    return this.boardColumnIntValue;
  }

  public static BoardColumn getBoardColumnForStringValue(String boardColumnStringValue) {
    switch (boardColumnStringValue) {
      case "A":
        return _A;

      case "B":
        return _B;

      case "C":
        return _C;

      case "D":
        return _D;

      case "E":
        return _E;

      case "F":
        return _F;

      case "G":
        return _G;

      case "H":
        return _H;
    }

    return null;
  }

  public static BoardColumn getBoardColumnForIntValue(int boardColumnIntValue) {
    switch (boardColumnIntValue) {
      case 0:
        return _A;

      case 1:
        return _B;

      case 2:
        return _C;

      case 3:
        return _D;

      case 4:
        return _E;

      case 5:
        return _F;

      case 6:
        return _G;

      case 7:
        return _H;
    }

    return null;
  }

  @Override
  public String toString() {
    switch (this.boardColumnIntValue) {
      case 0:
        return "A";

      case 1:
        return "B";

      case 2:
        return "C";

      case 3:
        return "D";

      case 4:
        return "E";

      case 5:
        return "F";

      case 6:
        return "G";

      case 7:
        return "H";
    }

    return super.toString();
  }
}
