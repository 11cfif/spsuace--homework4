package ru.spsuace.homework4.exception.robot;

public class RobotConnectionImpl implements RobotConnection {

    private Robot robot;

    public RobotConnectionImpl(Robot robot) {
        this.robot = robot;
        System.out.println("Robot connection opened");
    }

    @Override
    public void moveRobotTo(int x, int y) {
        robot.setX(x);
        robot.setY(y);
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
    }

    @Override
    public void close() {
        System.out.println("Robot connection closed");
    }
}


