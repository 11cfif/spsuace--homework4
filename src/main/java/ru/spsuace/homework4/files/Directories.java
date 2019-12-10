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

        int count = 0;
        File dir1 = new File(path);
            if (!dir1.exists()) {
            return count;
            }
        File[] listFiles = dir1.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                listFiles[i].delete();
                count += 1;
            }
            if (listFiles[i].isDirectory()) {
                count += removeWithFile(listFiles[i].getPath());
            }
        }
        dir1.delete();
        count += 1;
        return count;
    }
}
    /**
     * С использованием Path
     */
   // public static int removeWithPath(String path) {
// Path start = Paths.get(path);
// DeleterVisitor deletePaths = new DeleterVisitor();
// try {
// Files.walkFileTree(start, deletePaths);
// } catch (IOException exception) {
// }
//
// return deletePaths.countFilesAndDirectories;
// }


