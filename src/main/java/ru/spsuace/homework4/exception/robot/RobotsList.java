package ru.spsuace.homework4.exception.robot;

import java.util.ArrayList;

class RobotsList extends ArrayList<Robot> {
    Robot getByName(String name) {
        for (Robot robot : this) {
            if (robot.getName().equals(name)) {
                return robot;
            }
        }
        return null;
    }

    Robot getByPosition(Position position){
        for (Robot robot : this) {
            if (robot.getPosition().equals(position)) {
                return robot;
            }
        }
        return null;
    }
}
