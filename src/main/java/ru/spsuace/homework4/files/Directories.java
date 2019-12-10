package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Directories {

    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     */

    public static int removeWithFile(String path) {

        int count = 0;
        File main = new File(path);
        if (!main.exists() && !main.isDirectory()) {
            return count;
        }
        File[] listFiles = main.listFiles();
        if (listFiles == null) {
            count = 1;
        } else {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    listFiles[i].delete();
                    count += 1;
                }
                if (listFiles[i].isDirectory()) {
                    count += removeWithFile(listFiles[i].getPath());
                }
            }
            main.delete();
            count += 1;
        };
        return count;
    }
}
    /**
     * С использованием Path
     */


