package ru.spsuace.homework4.files;

import java.io.File;
import java.util.Objects;

public class Directories {


    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     */
    public static int removeWithFile(String path) {
        final File file = new File(path);
        if (!file.exists()) {
            return 0;
        }
        return delete(file) + 1;
    }

    private static int delete(File file) {
        int count = 0;
        if (!file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                count++;
                count += delete(f);
            }
        }
        file.delete();
        return count;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) {
        return 0;
    }
}
