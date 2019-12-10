package ru.spsuace.homework4.files;

import org.junit.Test;
import ru.spsuace.homework4.exception.robot.Connection;
import ru.spsuace.homework4.exception.robot.Robot;
import ru.spsuace.homework4.exception.robot.RobotConnectionManager;

public class RobotTest {

    @Test
    public void MainTest() {
        Connection robotConnectManager = new Connection();
        for (int i = 1; i < 100; i++) {
            System.out.println(i +" attempt");

            if (Robot.func(Robot.getX(), Robot.getY()) < Robot.func(Robot.getX() + 1, Robot.getY())) {
                Robot.step(Robot.Direction.RIGHT);
            } else if (Robot.func(Robot.getX(), Robot.getY()) < Robot.func(Robot.getX(),Robot.getY() + 1)) {
                Robot.step(Robot.Direction.UP);
            } else if (Robot.func(Robot.getX(), Robot.getY()) < Robot.func(Robot.getX() - 1, Robot.getY())) {
                Robot.step(Robot.Direction.LEFT);
            } else if (Robot.func(Robot.getX(), Robot.getY()) < Robot.func(Robot.getX() , Robot.getY() - 1)) {
                Robot.step(Robot.Direction.DOWN);
            } else {
                return;
            }
            RobotConnectionManager.moveRobot(robotConnectManager, Robot.getX(), Robot.getY());
        }
    }
}