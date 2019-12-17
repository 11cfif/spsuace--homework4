package ru.spsuace.homework4.robots;

import org.junit.Test;
import ru.spsuace.homework4.exception.robot.*;

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
    public void placeMoreRobotsToField() {
        Field field = new Field(10, 10);
        Robot robot1 = new Robot("Anna");
        Robot robot2 = new Robot("Nik");
        field.addRobot(robot1, new Position(1, 2));
        field.addRobot(robot2, new Position(2, 3));
        assertArrayEquals(new Robot[]{robot1, robot2}, field.getRobots());
    }

    @Test
    public void testMoveRobot() {
        Field field = new Field(10, 10);
        Robot robot = new Robot("Anna");
        field.addRobot(robot, new Position(1, 2));
        ConnectionManager manager = new ConnectionManager(field);
        manager.selectRobot("Anna");
        RobotConnectionManager.moveRobot(manager, 4, 5);
        assertEquals(new Position(4, 5), robot.getPosition());
    }

    @Test
    public void collisionRobots(){
        Field field = new Field(10, 10);
        Robot robot1 = new Robot("Anna");
        Robot robot2 = new Robot("Nik");
        field.addRobot(robot1, new Position(1, 2));
        field.addRobot(robot2, new Position(1, 3));
        ConnectionManager manager = new ConnectionManager(field);
        manager.selectRobot("Anna");
        RobotConnectionManager.moveRobot(manager, 5, 1);
        manager.selectRobot("Nik");
        RobotConnectionManager.moveRobot(manager,5,1);
        assertNotEquals(robot1.getPosition(),robot2.getPosition());
        assertEquals(new Position(5,1),robot1.getPosition());
        assertEquals(new Position(4,1),robot2.getPosition());
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
