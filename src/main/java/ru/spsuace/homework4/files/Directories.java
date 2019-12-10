package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
        if (!main.exists()) {
            return count;
        }
        File[] listFiles = main.listFiles();
        if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    listFiles[i].delete();
                    count += 1;
                }
                if (listFiles[i].isDirectory()) {
                    count += removeWithFile(listFiles[i].getPath());
                }
            }
        }
        main.delete();
        count += 1;
        return count;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) throws IOException {
        final Path file = Paths.get(path);
        if (!file.toFile().exists()) {
            return 0;
        }
        return deletePath(file) + 1;
    }

    private static int deletePath(Path file) throws IOException {
        int count = 0;
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(file)) {
            for (Path entry : stream) {
                count++;
                count += deletePath(entry);
            }
        }
        Files.delete(file);
        return count;
    }
}
