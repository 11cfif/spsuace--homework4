package ru.spsuace.homework4.files;

import org.junit.Test;
import ru.spsuace.homework4.exception.robot.Robot;

import static junit.framework.TestCase.assertEquals;

public class RobotTest {
    @Test
    public void MainTest() {
        assertEquals(equals(new int[] {-4,8}), equals(Robot.main((x, y) -> (int)(-(Math.pow((x+4),2)+Math.pow((y-8),2))))));
        assertEquals(equals(new int[] {4,-12}), equals(Robot.main((x, y) -> (int)(-(Math.pow((x-4),2)+Math.pow((y+12),2))))));
    }
}