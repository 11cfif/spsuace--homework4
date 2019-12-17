package ru.spsuace.homework4.files;

import java.io.File;
import java.util.stream.Collectors;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

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
                    } else if (currentFile.isDirectory()) {
                        count += removeWithFile(currentFile.getPath());
                    }
                }
            }
            mainFile.delete();
            count += 1;
        }
        if (mainFile.isFile()) {
            mainFile.delete();
            count += 1;
        }
        return count;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path_1) {
        if (path_1 == null || path_1.isEmpty()) {
            return 0;
        }
        Path path = Paths.get(path_1);
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
