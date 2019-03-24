package ru.spsuace.homework4.exception.robot;

public class Connection implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        //Получить экземпляр робота
        //получить текущие координаты робота
        //Двигать с помощью makeStep пока не дойдет до заданных

    }

    @Override
    public void close() {
        throw new RobotException("close");
    }
}
