package ru.spsuace.homework4.exception.robot;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {
    private int x = 0;
    private int y = 0;
    private Direction direction = Direction.UP;

    public Robot(Direction direction, int x, int y){
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void turnLeft() {
                switch (direction) {
            case UP:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }
        System.out.println("Direction: "+direction);
    }

    public void turnRight() {
                switch (direction) {
            case UP:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
        }
        System.out.println("Direction: "+direction);
    }

    public void stepForward() {
        switch (direction) {
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
        System.out.println("Moving in direction: "+direction);
        System.out.println("(x;y) = (" + x + ";" + y + ")");
    }




}
