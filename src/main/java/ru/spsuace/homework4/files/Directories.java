package ru.spsuace.homework4.files;

import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Directories {


    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     */
    public static int removeWithFile(String path) {
        int countRemoved = 0;
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (Objects.requireNonNull(files).length > 0) {
                    for (File f : files) {
                        countRemoved += removeWithFile(f.getPath());
                    }
                }
            }
            return countRemoved + ((file.delete()) ? 1 : 0);
        } else {
            return 0;
        }
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) {
        int countRemoved = 0;
        Path file = Paths.get(path);
        if (file.toFile().exists()) {
            try {
                if (Files.isDirectory(file)) {
                    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(file)) {
                        for (Path f : directoryStream) {
                            countRemoved += removeWithPath(f.toString());
                        }
                    }
                }
                Files.delete(file);
                return countRemoved + 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
