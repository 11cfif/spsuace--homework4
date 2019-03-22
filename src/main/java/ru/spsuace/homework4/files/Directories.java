package ru.spsuace.homework4.files;

import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Directories {


    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * @param directory
     * @return
     */
    public static int remove(String directory){
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
