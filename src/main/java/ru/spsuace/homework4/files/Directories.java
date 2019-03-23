package ru.spsuace.homework4.files;

import java.io.File;

public class Directories {

    private int count = 0;

    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     *
     * @param
     * @return
     */
    public static int remove(String path) {
        File path1 = new File(path);

        return new Directories().recursiveDelete(path1);
    }

    private int recursiveDelete(File file) {
        if (!file.exists()) {
            return 0;
        }
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
        }
        file.delete();
        this.count++;
        return count;
    }

    public static void main(String[] arg) {
        System.out.println(Directories.remove("E:\\test"));
    }

}

