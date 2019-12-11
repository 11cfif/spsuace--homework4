package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Directories {


    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     */
    public static int removeWithFile(String path) {
        final File dir_folder = new File(path);
        int count = 0;
        if (dir_folder.exists()) {
            File[] allContents = dir_folder.listFiles();
            if (allContents != null) {
                for (File file : allContents) {
                    count += removeWithFile(file.toString());
                }
            }
            dir_folder.delete();
            return ++count;
        } else {
            return 0;
        }
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) {
       return 0;
    }


}
