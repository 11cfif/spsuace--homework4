package ru.spsuace.homework4.exception.robot;

/**
 * Дополнительное задание. Реализовать простого робота.
 * У него должны быть координаты, работа с ними и все остальное на ваше усмотрение
 * (Если придумаете что-нибудь интересное и красивое, получите 2 балла)
 */
public class Robot {
    int X;
    int Y;

    Robot(int x, int y){
        X = x;
        Y = y;
    }
    int GetX(){
        return X;
    }

    int GetY(){
        return Y;
    }

    void Step(int stepX, int stepY){
        X += stepX;
        Y += stepY;
    }
}
