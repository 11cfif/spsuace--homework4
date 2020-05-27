package ru.spsuace.homework4.exception.robot;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {

    private int currentX = 0;
    private int currentY = 0;
    private int endX;
    private int endY;

    public int getX() {
        return currentX;
    }

    public int getY() {
        return currentY;
    }

    public void setX(int endX) {
        this.endX = endX;
    }

    public void setY(int endY) {
        this.endY = endY;
    }

    public void moveRight() {
        currentX++;
    }

    public void moveLeft() {
        currentX--;
    }

    public void moveUp() {
        currentY++;
    }

    public void moveDown() {
        currentY--;
    }

    public boolean isFinished() {
        return (currentX == endX && currentY == endY);
    }
}



