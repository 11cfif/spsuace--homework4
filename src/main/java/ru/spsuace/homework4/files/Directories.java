package ru.spsuace.homework4.files;

import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Directories {

    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * @param path
     * @return
     */
    public static int remove(String path) {

        int count = 0;
        return deleteFile(Paths.get(path), count);
    }

    private static int deleteFile(Path pathOfFile, int count) {

        if (!Files.exists(pathOfFile)) {
            return count;
        }

        if (Files.isDirectory(pathOfFile)) {
            for (File f : (pathOfFile.toFile()).listFiles()) {
                count = deleteFile(f.toPath(), count);
            }
        }

        try {
            Files.delete(pathOfFile);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        count++;
        return count;
    }
}
