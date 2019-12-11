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
        final File file = new File(path);
        int count = 0;

        if (!file.exists() ) {
            return  0;
        }

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                if (children != null) {
                    for (File currentChild : children) {
                        if (currentChild.isFile()) {
                            currentChild.delete();
                            count += 1;
                        } else if (currentChild.isDirectory()) {
                            count += removeWithFile(currentChild.getPath());
                        }
                    }
                }
                file.delete();
                count += 1;
            }
            if (file.isFile()) {
                file.delete();
                count += 1;
            }
        }

        return count;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) throws IOException {
        final Path file = Paths.get(path);

        if (!file.toFile().exists()) {
            return 0;
        }
        List<Path> pathList = Files.walk(file)
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        for (Path item : pathList) {
            Files.deleteIfExists(item);
        }
        return pathList.size();
    }
}
