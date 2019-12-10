package ru.spsuace.homework4.exception.robot;

import java.util.function.BiFunction;

public class SimpleConnectionManager implements RobotConnectionManager {

    public SimpleConnectionManager(BiFunction<Integer, Integer, Integer> function) {
        Robot robot = new Robot(function);
        robot.ascend();
    }

    /**Вероятность с которой робот сделает шаг*/

    private boolean getRandom() {
        return Math.random() < 0.98;
    }

    @Override
    public RobotConnection getConnection() {
        RobotConnection robotConnection;
        boolean isConnect = getRandom();
        if (!isConnect) {
            System.out.println("No connection");
            throw new RobotConnectionException("Not connect");
        } else {
            System.out.println("There is a connection");
            robotConnection = new RobotConnection() {
                @Override
                public void moveRobotTo(int x, int y) {
                }

                @Override
                public void close() {
                }
            };
        }
        return robotConnection;
    }
}
