package ru.spsuace.homework4.exception.robot;

import com.sun.tools.jdi.ReferenceTypeImpl;

public class RobotException extends RuntimeException {
    RobotException(String message) {
        super(message);
    }
}
