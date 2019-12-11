package ru.spsuace.homework4.exception.robot;

public class RobotConnect implements RobotConnection {
    private Robot robot;
    private Field field;

    static RobotConnect openNew(String name, Field field) {
        Robot robot = field.getRobotByName(name);
        if (robot == null) {
            throw new RobotException(null, "connection to robot failed");
        }
        RobotConnect connect = new RobotConnect();
        connect.robot = robot;
        connect.field = field;
        return connect;
    }

    @Override
    public void moveRobotTo(int x, int y) {
        field.moveRobotByNameTo(robot.getName(), new Position(x, y));
    }

    @Override
    public void close() {
        robot = null;
        field = null;
    }
}
