package ru.spsuace.homework4.exception.robot;

public class Connection implements RobotConnection {
    private Robot robot;
    private Field field;

    static Connection openNew(String name, Field field) throws RobotException {
        Robot robot = field.getRobotByName(name);
        if (robot == null) {
            throw new RobotException(null, "connection to robot failed");
        }
        return new Connection(robot,field);
    }

    private Connection(Robot robot, Field field) {
        this.robot = robot;
        this.field = field;
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
