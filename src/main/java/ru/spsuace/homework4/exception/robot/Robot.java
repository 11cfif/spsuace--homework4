package ru.spsuace.homework4.exception.robot;

import java.util.function.BiFunction;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */

public class Robot {

    private static boolean finish = false;
    private BiFunction<Integer, Integer, Integer> function;

    Robot(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }

    public void ascend() {
        if (function.apply(x,y) < function.apply(x + 1,y)){
            step(Direction.RIGHT);
        } else if (function.apply(x,y) < function.apply(x,y + 1)){
            step(Direction.UP);
        } else if (function.apply(x,y) < function.apply(x - 1,y)){
            step(Direction.LEFT);
        } else if (function.apply(x,y) < function.apply(x ,y - 1)) {
            step(Direction.DOWN);
        } else {
            finish = true;
        }
    }

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

    public static int getX () {
        return x;
    }
    public static int getY () {
        return y;
    }

    public static boolean getFinish () {
        return finish;
    }
}
