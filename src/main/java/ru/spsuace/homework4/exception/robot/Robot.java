package ru.spsuace.homework4.exception.robot;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */

public class Robot {
    private int x = 0;
    private int y = 0;
    private Direction coords = Direction.UP;

    public Robot(Direction coordss, int x, int y) {
        this.coords = coordss;
        this.x = x;
        this.y = y;
    }

    public Direction getDirection() {
        return coords;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
        switch (coords) {
            case UP:
                coords = Direction.LEFT;
                break;
            case LEFT:
                coords = Direction.DOWN;
                break;
            case DOWN:
                coords = Direction.RIGHT;
                break;
            case RIGHT:
                coords = Direction.UP;
                break;
        }
        System.out.println("Direction: " + coords);
    }

    public void turnRight() {
        switch (coords) {
            case UP:
                coords = Direction.LEFT;
                break;
            case LEFT:
                coords = Direction.DOWN;
                break;
            case DOWN:
                coords = Direction.RIGHT;
                break;
            case RIGHT:
                coords = Direction.UP;
                break;
        }
        System.out.println("Direction: " + coords);
    }


    public void stepForward() {
        switch (coords) {
            case UP:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case DOWN:
                y--;
                break;
            case RIGHT:
                x++;
                break;
        }
        System.out.println("Moving in direction: " + coords);
        System.out.println("(x;y) = (" + x + ";" + y + ")");
    }
}


