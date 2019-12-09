package ru.spsuace.homework4.exception.robot;

/**Исключение соединения*/

class RobotConnectionException extends RuntimeException {
    RobotConnectionException(String message) {
        super(message);
    }
}
