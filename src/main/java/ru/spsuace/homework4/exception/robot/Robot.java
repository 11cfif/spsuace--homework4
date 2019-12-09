package ru.spsuace.homework4.exception.robot;

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

    /**Робот взберается в гору*/

    public static void main(String[] args) {
        RobotConnectManager robotConnectManager = new RobotConnectManager();
        for (int i = 1; i < 100; i++) {
            System.out.println(i +" attempt");

            if (func(x,y) < func(x + 1,y)){
                step(Direction.RIGHT);
            } else if (func(x,y) < func(x,y + 1)){
                step(Direction.UP);
            } else if (func(x,y) < func(x - 1,y)){
                step(Direction.LEFT);
            } else if (func(x,y) < func(x ,y - 1)) {
                step(Direction.DOWN);
            } else {
                return;
            }
            RobotConnectionManager.moveRobot(robotConnectManager, x, y);
        }
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

    /**Поверхность по которому ходит робот*/
    private static double func(int x, int y) {
        return -(Math.pow((x+4),2)+Math.pow((y-8),2));
    }

}
