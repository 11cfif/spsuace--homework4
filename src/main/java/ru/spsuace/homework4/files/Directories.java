package ru.spsuace.homework4.files;

import java.io.File;

public class Directories {


    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     */
    public static int removeWithFile(String path) {
        File folder = new File(path);
        int counter = 0;

        if (!folder.isDirectory()) {
            if (folder.isFile()) {
                folder.delete();
                return 1;
            } else {
                return 0;
            }
        }
        for (File item : folder.listFiles()) {
            if (item == null) {
                break;
            }
            if (item.isDirectory()) {
                counter += removeWithFile(item.getPath());
            } else {
                item.delete();
                counter++;
            }
        }
        folder.delete();
        counter++;

        return counter;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) {
        return 0;
    }
}
