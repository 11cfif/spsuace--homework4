package ru.spsuace.homework4.files;

import org.junit.Test;
import ru.spsuace.homework4.exception.robot.SimpleConnectionManager;
import ru.spsuace.homework4.exception.robot.Robot;
import ru.spsuace.homework4.exception.robot.RobotConnectionManager;

public class RobotTest {

    @Test
    public void MainTest() {
        int maximumSteps = 100;
        for (int i = 1; i < maximumSteps; i++) {
            SimpleConnectionManager robotConnectManager = new SimpleConnectionManager((x, y) -> (int)(-(Math.pow((x+4),2)+Math.pow((y-8),2))));
            System.out.println(i +" attempt");
            RobotConnectionManager.moveRobot(robotConnectManager, Robot.getX(), Robot.getY());
            if (Robot.getFinish()) {
                return;
            }
        }
    }
}