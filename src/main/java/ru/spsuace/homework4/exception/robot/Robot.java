package ru.spsuace.homework4.exception.robot;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {
    private int x;
    private int y;
    private Direction direction = Direction.UP;


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void makeStep() {
        switch (direction){
            case UP:
                y++;
                break;
            case BOTTOM:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
    }
}
