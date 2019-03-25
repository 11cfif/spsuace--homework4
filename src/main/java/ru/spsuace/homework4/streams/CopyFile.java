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
    public static String copySmallFiles(String pathFrom, String pathTo) {
        try {
            FileWriter writer = new FileWriter(new File(pathTo));
            Path path = Paths.get(pathFrom);
            List<String> allLines = Files.readAllLines(Paths.get(pathFrom),
                    Charset.forName("windows-1251"));
            return "Ok";
        } catch (IOException ex) {
            return ex.toString();
        }
    }

    /**
     * Реализовать копирование больших файлов.
     */
    public static void copyBigFiles(String pathFrom, String pathTo) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFrom))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathTo))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line + "\n");
                }
            }
        }
    }

}


