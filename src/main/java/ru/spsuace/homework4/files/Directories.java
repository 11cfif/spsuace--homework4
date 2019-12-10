package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
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
        final File file = new File(path);

        if (!file.exists()) {
            return 0;
        }

        return deleteWithFile(file) + 1;
    }

    private static int deleteWithFile(File file) {
        int count = 0;

        if (!file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                count++;
                count += deleteWithFile(f);
            }
        }

        file.delete();
        return count;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path){
        final Path file = Paths.get(path);

        if (!file.toFile().exists()) {
            return 0;
        }

        return deleteWithPath(file) + 1;
    }

    private static int deleteWithPath(Path file) {
        int count = 0;

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(file)) {
            for (Path entry : stream) {
                count++;
                count += deleteWithPath(entry);
            }
        } catch (IOException e) {
        }

        try {
            Files.delete(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }
}
