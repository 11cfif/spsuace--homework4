package ru.spsuace.homework4.files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Directories extends SimpleFileVisitor<Path> {
    private static int i = 0;
    private static Directories fileDir = new Directories();

    @Override
    public FileVisitResult visitFile(Path dir, BasicFileAttributes attrs) throws IOException {
        if (Files.deleteIfExists(dir)) {
            i++;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path dir, IOException exc) throws IOException {
        if (Files.deleteIfExists(dir)) {
            i++;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (exc == null) {
            Files.delete(dir);
            i++;
            return FileVisitResult.CONTINUE;
        } else {
            throw exc;
        }
    }

    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     */
    public static int remove(String path) throws IOException {
        i = 0;
        Path directory = Paths.get(path);
        if (!Files.exists(directory)) {
            return 0;
        }
        Files.walkFileTree(directory, fileDir);
        return i;
    }
}
