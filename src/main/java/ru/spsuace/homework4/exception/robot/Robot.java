package ru.spsuace.homework4.exception.robot;

import org.graalvm.compiler.graph.NodeList;

import java.util.ArrayList;
import java.util.List;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {

    int X;
    int Y;


    List<Coord> arrCoord = new ArrayList<>();

    void addMemory(int x, int y) {
        arrCoord.add(new Coord(x,y));
    }

    void clearMemory() {
        arrCoord.clear();
    }

    Robot(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    int getX() {
        return X;
    }

    int getY() {
        return Y;
    }

    void move(int dX, int dY) {
        this.X += dX;
        this.Y += dY;
        addMemory(X, Y);
    }

    void tp(int dX, int dY) {
        this.X = dX;
        this.Y = dY;
        addMemory(X, Y);
    }


}
