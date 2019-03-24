package ru.spsuace.homework4.streams;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;


public class CopyFile {

    /**
     * Реализовать копирование маленьких файлов, через чтение и запись всех строк разом.
     * Если не получилось скопировать файл, то вернуть причину. Если получилось - вернуть "Ok"
     */
    private static String getExtension(String path) {
        String fileExtension = "";
        if (path.indexOf(".") != -1) {
            fileExtension = path.substring(path.indexOf("."));
        }
        return fileExtension;
    }

    public static String copySmallFiles(String pathFrom, String pathTo) throws Exception {
        Files.write(Paths.get(pathTo + getExtension(pathFrom)), Files.readAllLines(Paths.get(pathFrom), Charset.forName("windows-1251")));
        return "Ok";
    }

    /**
     * Реализовать копирование больших файлов.
     */
    public static void copyBigFiles(String pathFrom, String pathTo) throws IOException {
        Files.copy(Paths.get(pathFrom), Paths.get(pathTo + getExtension(pathFrom)));
    }

    public static void main(String[] arg) throws Exception {
        copySmallFiles("E:\\test.txt", "E:\\test1.txt");
    }

}


