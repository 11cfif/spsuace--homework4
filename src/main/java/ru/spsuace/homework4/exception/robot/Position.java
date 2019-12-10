package ru.spsuace.homework4.exception.robot;

import javafx.geometry.Pos;

public class Position {
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private final int x;
    private final int y;

    int getY() {
        return y;
    }

    int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object position) {
        if (position instanceof Position) {
            return (((Position) position).getX() == x) && (((Position) position).getY() == y);
        }
        return false;
    }
}
