package ru.spsuace.homework4.files;

import java.io.File;

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
        File[] children;
        if (mainDir.exists() && mainDir.isDirectory()){
            children = mainDir.listFiles();
            if (children != null){
                for (File currentChild : children) {
                    if (currentChild.isFile()) {
                        currentChild.delete();
                        countDeletedFilesDirs += 1;
                    } else if (currentChild.isDirectory()){
                        countDeletedFilesDirs += removeWithFile(currentChild.getPath());;
                    }

                }
            }
            mainDir.delete();
            countDeletedFilesDirs += 1;
        } else if (mainDir.isFile()){
            mainDir.delete();
            countDeletedFilesDirs += 1;
        }
        return  countDeletedFilesDirs;
    }

    /**
     * С использованием Path
     */
    public static int removeWithPath(String path) {
      return 0;
    }
}
