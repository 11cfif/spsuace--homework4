package ru.spsuace.homework4.streams;

import java.io.IOException;

/**
 * Для этого задания надо использовать только новый API (нельзя использовать класс File)
 */
public class CopyFile {

    /**
     * Реализовать копирование маленьких файлов, через чтение и запись всех строк разом.
     * Если не получилось скопировать файл, то вернуть причину. Если получилось - вернуть "Ok"
     * Для маленьких фалов есть отличный стрим для этой задачи
     */
    public static String copySmallFiles(String pathFrom, String pathTo) {
        return null;
    }

    /**
     * Реализовать копирование больших файлов. Как и в задании выше, надо реализовать задание
     * через стримы. Класс для стримов из верхнего задания использовать нельзя
     */
    public static void copyBigFiles(String pathFrom, String pathTo) throws IOException {
    }
}
