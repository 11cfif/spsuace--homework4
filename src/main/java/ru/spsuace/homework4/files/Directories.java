package ru.spsuace.homework4.files;

import java.io.File;
import java.io.IOException;
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

        int count = 0;
        if (mainFile.exists() && mainFile.isDirectory()) {
            File[] allContents = mainFile.listFiles();
            if (allContents != null) {
                for (File currentFile : allContents) {
                    if (currentFile.isFile()) {
                        currentFile.delete();
                        count += 1;
                    }
                    if (currentFile.isDirectory()) {
                        count += removeWithFile(currentFile.getPath());
                    }
                }
                count += 1;
            } else {
                return count;
            }
            mainFile.delete();
        } else {
            return 0;
        }
        return count;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String directory) {
        if (directory == null || directory.isEmpty()) {
            return 0;
        }

        Path path = Paths.get(directory);

        if (Files.exists(path)) {

            try {
                List<Path> pathList = Files.walk(path)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

                for (Path item : pathList) {
                    Files.deleteIfExists(item);
                }
                return pathList.size();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return 0;
    }
}