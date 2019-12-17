package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class Directories {


    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     */
    public static int removeWithFile(String path) {
        File currentFile = new File(path);
        if (!currentFile.exists()) {
            return 0;
        }

        int count = 1;
        if (currentFile.isDirectory()) {
            for (File file : currentFile.listFiles()) {
                count += removeWithFile(file.getPath());
            }
        }
        currentFile.delete();

        return count;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) {
        Path currentPath = Paths.get(path);
        if (!Files.exists(currentPath)) {
            return 0;
        }

        long count = 0;

        try {
            count = Files.walk(currentPath).count();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.walk(currentPath)
                    .sorted(Comparator.reverseOrder())
                    .forEach(x -> {
                        try {
                            Files.delete(x);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return (int) count;
    }
}
