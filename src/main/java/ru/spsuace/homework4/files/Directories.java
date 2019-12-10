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
        int counter = 0;
        File file = new File(path);
        if( !file.exists()) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File listFile : listFiles) {
                if (listFile.isFile()) {
                    listFile.delete();
                    counter++;
                }
                if (listFile.isDirectory()) {
                    counter += removeWithFile(listFile.getPath());
                }
                listFile.delete();
            }
        }
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
