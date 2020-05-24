package ru.spsuace.homework4.exception.robot;

public class RobotConnectionImpl implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        Robot robot = new Robot(x, y);
        if (robot.getConnection()) {
            int currentX = robot.getX();
            int currentY = robot.getY();
            while (!robot.isFinished()) {
                if (x > currentX) {
                    robot.moveRight();
                } else if (x < currentX) {
                    robot.moveLeft();
                }
                currentX = robot.getX();
                if (y > currentY) {
                    robot.moveUp();
                } else if (y < currentY) {
                    robot.moveDown();
                }
                currentY = robot.getY();
            }
            close();
        } else {
            close();
        }
    }

    @Override
    public void close() {
        System.out.println("Robot connection closed");
    }
}


