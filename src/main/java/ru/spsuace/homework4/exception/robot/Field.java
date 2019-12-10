package ru.spsuace.homework4.exception.robot;

public class Field {

    private RobotsList robots = new RobotsList();
    private int width;
    private int height;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Robot[] getRobots() {
        return robots.toArray(new Robot[0]);
    }

    public void addRobot(Robot robot, Position position) {
        if (robots.getByName(robot.getName()) != null) {
            throw new RobotException(robot, "already exist in this field");
        }
        if (robots.getByPosition(robot.getPosition()) != null) {
            throw new RobotException(robot, "was placed in the position of another robot");
        }
        if (!positionInField(position)) {
            throw new RobotException(robot, "was placed outside the field");
        }
        robot.setPosition(position);
        robots.add(robot);
    }

    private boolean positionInField(Position position) {
        if (position.getX() > width || position.getX() < 0) {
            return false;
        }
        return position.getY() <= height && position.getY() >= 0;
    }
}
