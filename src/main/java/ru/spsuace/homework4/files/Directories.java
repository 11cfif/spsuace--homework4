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

//        return 0;
        final File mainDirectory = new File(path);
        int deletedFiles = 0;
        if (mainDirectory.exists()) {
            if (mainDirectory.isDirectory()) {
                File[] subDirectory = mainDirectory.listFiles();
                if (subDirectory != null) {
                    for (File currentSub : subDirectory) {
                        if (currentSub.isFile()) {
                            currentSub.delete();
                            deletedFiles += 1;
                        } else if (currentSub.isDirectory()) {
                            deletedFiles += removeWithFile(currentSub.getPath());
                        }
                    }
                }
                mainDirectory.delete();
                deletedFiles += 1;
            }
            if (mainDirectory.isFile()) {
                mainDirectory.delete();
                deletedFiles += 1;
            }
        }
        return deletedFiles;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) throws IOException {
        RemoverVisitor delete = new RemoverVisitor();
        Files.walkFileTree(Paths.get(path), delete);
        return delete.countDeletedElements;
    }

    public static class RemoverVisitor extends SimpleFileVisitor<Path> implements FileVisitor<Path> {

        int countDeletedElements = 0;

        @Override
        public FileVisitResult visitFile(java.nio.file.Path path, BasicFileAttributes basicFileAttributes) throws IOException {
            File current = path.toFile();
            current.delete();
            countDeletedElements++;
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(java.nio.file.Path path, IOException e) throws IOException {
            return FileVisitResult.TERMINATE;
        }

        @Override
        public FileVisitResult postVisitDirectory(java.nio.file.Path path, IOException e) throws IOException {
            File current = path.toFile();
            current.delete();
            countDeletedElements++;
            return FileVisitResult.CONTINUE;
        }
    }
}
