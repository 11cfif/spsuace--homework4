package ru.spsuace.homework4.files;

import java.io.File;

public class Directories {

    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * @param path
     * @return
     */
    public static int remove(String path) {

        int count = 0;
        return deleteFile(new File(path), count);
    }

    private static int deleteFile(File file, int count) {

        if (!file.exists())
            return count;

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                count = deleteFile(f, count);
            }
        }

        file.delete();
        count++;
        return count;
    }
}
