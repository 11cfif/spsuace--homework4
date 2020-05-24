package ru.spsuace.homework4.exception.robot;

public class RobotConnectionException extends RuntimeException {
    public RobotConnectionException() {
        super("Robot connection error!");
    }
}
