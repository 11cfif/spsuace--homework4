package ru.spsuace.homework4.exception.robot;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {

    private boolean connection = true;
    private int currentX = 0;
    private int currentY = 0;
    private int endX;
    private int endY;

    public Robot(int endX, int endY) {
        this.endX = endX;
        this.endY = endY;
        System.out.println("Robot connection opened");
    }

    public int getX() {
        return currentX;
    }

    public int getY() {
        return currentY;
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
        if (currentX == endX && currentY == endY) {
            connection = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean getConnection() {
        return connection;
    }


}
