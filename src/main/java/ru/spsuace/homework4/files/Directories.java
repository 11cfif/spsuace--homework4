package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
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
        final File mainFile = new File(path);

        int countFilesAndDirectories = 0;
        if (mainFile.exists() && mainFile.isDirectory()) {
            File[] allContents = mainFile.listFiles();
            if (allContents != null) {
                for (File currentFile : allContents) {
                    if (currentFile.isFile()) {
                        currentFile.delete();
                        countFilesAndDirectories += 1;
                    }
                    if (currentFile.isDirectory()) {
                        countFilesAndDirectories += removeWithFile(currentFile.getPath());
                    }
                }
                countFilesAndDirectories += 1;
            } else {
                countFilesAndDirectories = 1;
                return countFilesAndDirectories;
            }
            mainFile.delete();
        } else {
            return 0;
        }
        return countFilesAndDirectories;
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
        try (DirectoryStream<Path> stream = (DirectoryStream<Path>) Files.walk(file).sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            for (Path entry : stream) {
                count += deletePath(entry);
                count++;
            }
        }
        return count;
    }
}
