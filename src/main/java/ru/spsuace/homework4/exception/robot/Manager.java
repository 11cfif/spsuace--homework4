package ru.spsuace.homework4.exception.robot;

import java.util.Random;

public class Manager implements RobotConnectionManager {

    boolean isOk;//задаем удачное ли соединение

    private int random() {
        Random random = new Random();
        return random.nextInt(10);
    }

    @Override
    public RobotConnection getConnection() {

        if (random() < 5) {
            isOk = true;
            return new Connection();
        } else {
            isOk = false;
            throw new RobotException("connection failed");
        }

    }
}
