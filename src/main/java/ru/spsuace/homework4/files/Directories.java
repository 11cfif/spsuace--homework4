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
        final File mainDir = new File(path);
        int countDeletedFilesDirs = 0;
        if (mainDir.exists()) {
            if (mainDir.isDirectory()) {
                File[] children= mainDir.listFiles();
                if (children != null) {
                    for (File currentChild : children) {
                        if (currentChild.isFile()) {
                            currentChild.delete();
                            countDeletedFilesDirs += 1;
                        } else if (currentChild.isDirectory()) {
                            countDeletedFilesDirs += removeWithFile(currentChild.getPath());
                        }
                    }
                }
                mainDir.delete();
                countDeletedFilesDirs += 1;
            }
            if (mainDir.isFile()) {
                mainDir.delete();
                countDeletedFilesDirs += 1;
            }
        }
        return countDeletedFilesDirs;
    }

    /**
     * С использованием Path
     */

    public static class DeleterVisitor extends SimpleFileVisitor<Path> {
        int countFAndD = 0;

        @Override
        public FileVisitResult postVisitDirectory(Path path, IOException exc) throws IOException {
            Files.delete(path);
            countFAndD += 1;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) throws IOException {
            Files.delete(path);
            countFAndD += 1;
            return FileVisitResult.CONTINUE;
        }
    }

    public static int removeWithPath(String path) {
        Path start = Paths.get(path);
        DeleterVisitor deletePaths = new DeleterVisitor();
        try {
            Files.walkFileTree(start, deletePaths);
        } catch (IOException exception) {
        }
        return deletePaths.countFAndD;
    }
}

