package ru.spsuace.homework4.streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
        if (pathFrom == null || pathTo == null || pathFrom.isEmpty() || pathTo.isEmpty()) {
            return "NPE";
        }
        String ans = "";
        try {
            Files.write(Paths.get(pathTo), Files.readAllLines(Paths.get(pathFrom), StandardCharsets.UTF_8));
            ans = "Ok";
        } catch (IOException e) {
            ans = e.getMessage();
        }
        return ans;
    }

    /**
     * Реализовать копирование больших файлов. Как и в задании выше, надо реализовать задание
     * через стримы. Класс для стримов из верхнего задания использовать нельзя
     */
    public static void copyBigFiles(String pathFrom, String pathTo) throws IOException {
        try (
                FileReader fileReader = new FileReader(pathFrom);
                FileWriter fileWriter = new FileWriter(pathTo);
                Scanner scanner = new Scanner(fileReader)) {
            while (scanner.hasNextLine()) {
                fileWriter.write(scanner.nextLine());
            }
        }
    }
}
