package ru.spsuace.homework4.exception.robot;

import java.util.function.BiFunction;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {

    private static int x = 0;
    private static int y = 0;

    private enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**Робот взбирается в гору*/

    public static int[] main(BiFunction<Integer, Integer, Integer> function) {
        Connection robotConnectManager = new Connection();
        for (int i = 1; i < 100; i++) {
            System.out.println(i +" attempt");

            if (function.apply(x,y) < function.apply(x + 1,y)) {
                step(Direction.RIGHT);
            } else if (function.apply(x,y) < function.apply(x,y + 1)) {
                step(Direction.UP);
            } else if (function.apply(x,y) < function.apply(x - 1,y)) {
                step(Direction.LEFT);
            } else if (function.apply(x,y) < function.apply(x ,y - 1)) {
                step(Direction.DOWN);
            } else {
                return new int[] {x, y};
            }
            RobotConnectionManager.moveRobot(robotConnectManager, x, y);
        }
        return new int[] {x, y};
    }

    /**Шаги*/

    private static void step(Direction direction) {
        switch (direction){
            case UP:
                y++;
                break;
            case DOWN:
                y--;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }
    }

}
