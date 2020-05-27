package ru.spsuace.homework4.exception.robot;

public class RobotConnectionManagerImpl implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        try {
            Robot robot = new Robot();
            RobotConnection connection = new RobotConnectionImpl(robot);
            return connection;
        } catch (Exception e) {
            throw new RobotConnectionException();
        }
    }
}
