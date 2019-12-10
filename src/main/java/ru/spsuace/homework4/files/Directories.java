package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

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
    public static class DeleterVisitor extends SimpleFileVisitor<Path> {
        int countFilesAndDirectories = 0;

        @Override
        public FileVisitResult postVisitDirectory(Path path, IOException exc) throws IOException {
            Files.delete(path);
            countFilesAndDirectories += 1;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            Files.delete(path);
            countFilesAndDirectories += 1;
            return FileVisitResult.CONTINUE;
        }
    }

    public static int removeWithPath(String path) throws IOException {
        Path start = Paths.get(path);
        DeleterVisitor deletePaths = new DeleterVisitor();
        try {
            Files.walkFileTree(start, deletePaths);
        } catch (IOException exception) {
        }

        return deletePaths.countFilesAndDirectories;
    }
}
