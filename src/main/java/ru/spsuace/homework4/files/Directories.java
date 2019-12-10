package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class Directories {

    public static int countRemoveElement;

    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     */
    public static int removeWithFile(String path) {
        final File file = new File(path);
        countRemoveElement = 1;

        return deleteWithFile(file);
    }

    private static int deleteWithFile(File file) {

        if (!file.exists()) {
            return 0;
        }

        if (file.isDirectory()) {
            for (File f : Objects.requireNonNull(file.listFiles())) {
                countRemoveElement++;
                deleteWithFile(f);
            }
        }

        file.delete();
        return countRemoveElement;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) throws IOException {

        final Path file = Paths.get(path);
        countRemoveElement = 1;

        return deleteWithPath(file);
    }

    private static int deleteWithPath(Path file) throws IOException {

        if (!file.toFile().exists()) {
            return 0;
        }

        if (file.toFile().isDirectory()) {
            for (File f : Objects.requireNonNull(file.toFile().listFiles())) {
                countRemoveElement++;
                deleteWithPath(f.toPath());
            }
        }

        Files.delete(file);
        return countRemoveElement;
    }
}
