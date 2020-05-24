package ru.spsuace.homework4.exception.robot;

public class RobotConnectionManagerImpl implements RobotConnectionManager {
    @Override
    public RobotConnection getConnection() {
        try {
            RobotConnection connection = new RobotConnectionImpl();
            return connection;
        } catch (Exception e) {
            throw new RobotConnectionException();
        }
    }
}
