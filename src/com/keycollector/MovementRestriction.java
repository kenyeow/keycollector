package com.keycollector;

public class MovementRestriction {

    private int ableToMoveHorizontal;
    private int ableToMoveVertical;
    private int ableToMoveDiagonal;

    public MovementRestriction(int ableToMoveVertical, int ableToMoveHorizontal,
                               int ableToMoveDiagonal){
        this.ableToMoveVertical = ableToMoveVertical;
        this.ableToMoveHorizontal = ableToMoveHorizontal;
        this.ableToMoveDiagonal = ableToMoveDiagonal;
    }

    public int getAbleToMoveVertical() {
        return ableToMoveVertical;
    }

    public int getAbleToMoveHorizontal() {
        return ableToMoveHorizontal;
    }

    public int getAbleToMoveDiagonal() {
        return ableToMoveDiagonal;
    }
}
