package ru.spsuace.homework4.exception.robot;

public class ConnectionManager implements RobotConnectionManager {
    private String robotName;
    private Field field;

    public ConnectionManager(Field field) {
        this.field = field;
    }

    @Override
    public RobotConnection getConnection() {
        if (robotName == null) {
            throw new NullPointerException("robot name is null");
        }
        if (field == null) {
            throw new NullPointerException("field is null");
        }
        return Connection.openNew(robotName, field);
    }

    public void selectRobot(String robotName) {
        this.robotName = robotName;
    }

    public void changeField(Field field) {
        this.field = field;
    }
}
