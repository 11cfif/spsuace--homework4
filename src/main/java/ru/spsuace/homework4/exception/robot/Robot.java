package ru.spsuace.homework4.exception.robot;

import java.awt.*;
import java.util.ArrayList;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {
    private String name;
    private Position position;
    private ArrayList<Position> positionHistory = new ArrayList<>();

    public boolean move(Direction direction) {
        int x = 0, y = 0;
        switch (direction) {
            case RIGHT:
                x++;
                break;
            case LEFT:
                x--;
                break;
            case DOWN:
                y--;
                break;
            case UP:
                y++;
                break;
        }
        positionHistory.add(position);
        position = new Position(position.getX() + x, position.getY() + y);
        return true;
    }

    public Position[] getPositionHistory() {
        return (Position[]) positionHistory.toArray();
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public Robot(String name) {
        this.name = name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "robot " + name + " " + position;
    }
}
