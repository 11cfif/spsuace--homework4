package ru.spsuace.homework4.robots;

import org.junit.Test;
import ru.spsuace.homework4.exception.robot.Field;
import ru.spsuace.homework4.exception.robot.Position;
import ru.spsuace.homework4.exception.robot.Robot;

import static org.junit.Assert.*;


public class RobotsTest {
    @Test
    public void placeRobotToField() {
        Field field = new Field(10, 10);
        Robot robot = new Robot("Anna");
        field.addRobot(robot, new Position(1, 2));
        assertSame(robot, getRobotByName(field.getRobots(), "Anna"));
    }

    @Test
    public void placeMoreRobotsToField(){
        Field field = new Field(10, 10);
        Robot robot1 = new Robot("Anna");
        Robot robot2 = new Robot("Nik");
        field.addRobot(robot1,new Position(1,2));
        field.addRobot(robot2,new Position(2,3));
        assertArrayEquals(new Robot[]{robot1,robot2},field.getRobots());
    }

    private Robot getRobotByName(Robot[] robots, String name) {
        for (Robot robot : robots) {
            if (robot.getName().equals(name)) {
                return robot;
            }
        }
        return null;
    }
}
