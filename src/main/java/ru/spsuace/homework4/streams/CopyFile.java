package ru.spsuace.homework4.streams;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;

/**
 * Для этого задания надо использовать только новый API (нельзя использовать класс File)
 */
public class CopyFile {

    /**
     * Реализовать копирование маленьких файлов, через чтение и запись всех строк разом.
     * Если не получилось скопировать файл, то вернуть причину. Если получилось - вернуть "Ok"
     * Для маленьких фалов есть отличный стрим для этой задачи
     */
    public static String copySmallFiles(String pathFrom, String pathTo) {

        try {
            Files.write(Paths.get(pathTo), Files.readAllLines(Paths.get(pathFrom),
                    Charset.forName("windows-1251")));
            return "OK!";
        } catch (IOException ex) {
            return ex.toString();
        }
    }

    /**
     * Реализовать копирование больших файлов. Как и в задании выше, надо реализовать задание
     * через стримы. Класс для стримов из верхнего задания использовать нельзя
     */
    public static void copyBigFiles(String pathFrom, String pathTo) throws IOException {
        try (BufferedReader buffReader = new BufferedReader(new FileReader(pathFrom))) {
            try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter(pathTo))) {
                String str;
                while ((str = buffReader.readLine()) != null) {
                    buffWriter.write(str + "\n");
                }
            }
        }
    }
}
