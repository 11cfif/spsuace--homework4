package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path directory = Paths.get(path);
        int counter = 0;

        if (!Files.isDirectory(directory)) {
            if (Files.isRegularFile(directory)) {
                try {
                    Files.delete(directory);
                } catch (IOException e) {
                    System.out.println(e);
                }
                return 1;
            } else {
                return 0;
            }
        }
        try {
            List<Path> directoryList = Files.walk(directory)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
            for (Path item : directoryList) {
                Files.deleteIfExists(item);
                counter++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return counter;
    }
}
