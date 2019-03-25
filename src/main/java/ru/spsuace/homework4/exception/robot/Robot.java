package ru.spsuace.homework4.exception.robot;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot implements RobotConnection, RobotConnectionManager{
    @Override
    public RobotConnection getConnection() {
        return null;
    }

    @Override
    public void moveRobotTo(int x, int y) {

    }

    @Override
    public void close() {

    }
}
