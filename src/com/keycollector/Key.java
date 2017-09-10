package com.keycollector;

import javax.swing.*;

public class Key{

    private ImageIcon icon;
    private MovementRestriction movementRestriction;

    public Key(ImageIcon icon, int ableToMoveHorizontal, int ableToMoveVertical,
               int ableToMoveDiagonal){
        this.icon = icon;
        movementRestriction = new MovementRestriction(ableToMoveHorizontal,
                ableToMoveVertical, ableToMoveDiagonal);
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public MovementRestriction getMovementRestriction() {
        return movementRestriction;
    }
}