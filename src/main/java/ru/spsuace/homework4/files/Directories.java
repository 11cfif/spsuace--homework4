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
        int countDirectories = 0;
        File Directory = new File(path);
        if (!Directory.exists()) {
            return countDirectories;
        } else {
            if (Directory.isDirectory()) {
                File[] DirectoryFiles = Directory.listFiles();
                if (DirectoryFiles != null) {
                    for (File currentFile : DirectoryFiles) {
                        if (currentFile.isFile()) {
                            currentFile.delete();
                            countDirectories += 1;
                        } else if (currentFile.isDirectory()) {
                            countDirectories += removeWithFile(currentFile.getPath());
                        }
                    }
                }
                Directory.delete();
                countDirectories += 1;
            }
            if (Directory.isFile()) {
                Directory.delete();
                countDirectories += 1;
            }
        }
        return countDirectories;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) {
        return 0;
    }
}
