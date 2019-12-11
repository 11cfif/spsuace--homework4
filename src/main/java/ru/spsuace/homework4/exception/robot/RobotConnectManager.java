package ru.spsuace.homework4.exception.robot;

public class RobotConnectManager implements RobotConnectionManager {

    private static final int EXCEPTION_LIMIT = 2;

    private String robotName;
    private Field field;

    public RobotConnectManager(Field field) {
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
        int exceptionLimit = EXCEPTION_LIMIT;
        while (true) {
            try {
                return RobotConnect.openNew(robotName, field);
            } catch (RobotException e) {
                exceptionLimit--;
                if (exceptionLimit > 0) {
                    System.out.println("Connection failed, attempt left " + exceptionLimit + 1);
                } else {
                    throw e;
                }
            }
        }
    }

    public void selectRobot(String robotName) {
        this.robotName = robotName;
    }

    public void changeField(Field field) {
        this.field = field;
    }
}
