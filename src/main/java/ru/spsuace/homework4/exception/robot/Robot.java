package ru.spsuace.homework4.exception.robot;


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

    void step(Position targetPosition) {
        positionHistory.add(position);
        position = getNextPosition(targetPosition);
    }

    Position getNextPosition(Position targetPosition) {
        int x = 0, y = 0;
        if (targetPosition.getX() > position.getX()) {
            x++;
        }
        if (targetPosition.getX() < position.getX()) {
            x--;
        }
        if (targetPosition.getY() > position.getY()) {
            y++;
        }
        if (targetPosition.getY() < position.getY()) {
            y--;
        }
        return new Position(position.getX() + x, position.getY() + y);
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
