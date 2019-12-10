package ru.spsuace.homework4.exception.robot;

import java.util.function.BiFunction;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {


    /**Поверхность по которому ходит робот*/
    private static int x = 0;
    private static int y = 0;

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**Шаги*/
    public static void step(Direction direction) {
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
    public static double func(int x, int y) {
        return -(Math.pow((x+4),2)+Math.pow((y-8),2));
    }

    public static int getX () {
        return x;
    }
    public static int getY () {
        return y;
    }
}
