package ru.spsuace.homework4.exception.robot;

/**
 * Подключение к роботу, которое позволяет его перемещать в заданную точку.
 * Подключение временное, которое нужно закрывать, когда оно нам больше не надо.
 */
public interface RobotConnection extends AutoCloseable {

    /**
     * Перемещает робота в заданную точку.
     * В любой момент соединение может оборваться и тогда любой из методов может кинуть непроверяемое исключение
     */
    void moveRobotTo(int x, int y);

    @Override
    void close();
}
