package ru.spsuace.homework4.files;

import javax.naming.NamingException;
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
     *
     * @return
     */
    public static int removeWithFile(String path) {
        int count = 0;
        File directory = new File(path);
        if (!directory.exists()) {
            return count;
        }
        File[] listFiles = directory.listFiles();
        if (listFiles == null) {
            count += 1;
            directory.delete();
        } else {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    listFiles[i].delete();
                    count += 1;
                }
                if (listFiles[i].isDirectory()) {
                    count += removeWithFile(listFiles[i].getPath());
                }
            }
            directory.delete();
            count += 1;
        }
        return count;
    }


    /**
     * С использованием Path
     */

    public static class RemoveVisitor extends SimpleFileVisitor<Path> {
        int count = 0;

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            Files.delete(dir);
            count += 1;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path dir, BasicFileAttributes attrs) throws IOException {
            Files.delete(dir);
            count += 1;
            return FileVisitResult.CONTINUE;
        }
    }

    public static int removeWithPath(String path) {
        Path start = Paths.get(path);
        RemoveVisitor deletePaths = new RemoveVisitor();
        try {
            Files.walkFileTree(start, deletePaths);
        } catch (IOException exception) {
        }
        return deletePaths.count;
    }
}


