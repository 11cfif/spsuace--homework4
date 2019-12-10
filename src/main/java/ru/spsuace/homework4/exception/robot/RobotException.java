package ru.spsuace.homework4.exception.robot;

class RobotException extends RuntimeException {
    RobotException(Robot robot, String message) {
        super(robot + " " + message);
    }
}
