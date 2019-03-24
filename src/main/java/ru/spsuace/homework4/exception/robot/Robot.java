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

    public void rotation(boolean isLeftRotation) {
        if (!isLeftRotation) {
            rightRotation();
        } else {
            leftRotation();
        }
    }

    private void leftRotation(){
        switch (direction){
            case UP:
                direction = Direction.LEFT;
                break;
            case BOTTOM:
                direction = Direction.RIGHT;
                break;
            case LEFT:
                direction = Direction.BOTTOM;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
        }
    }

    private void rightRotation(){
        switch (direction){
            case UP:
                direction = Direction.RIGHT;
                break;
            case BOTTOM:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.BOTTOM;
                break;
        }
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
