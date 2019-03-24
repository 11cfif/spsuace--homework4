package ru.spsuace.homework4.streams;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;

public class CopyFile {

    /**
     * Реализовать копирование маленьких файлов, через чтение и запись всех строк разом.
     * Если не получилось скопировать файл, то вернуть причину. Если получилось - вернуть "Ok"
     */
    public static String copySmallFiles(String pathFrom, String pathTo) {

        try {
            List<String> lines = Files.readAllLines(Paths.get(pathFrom), Charset.forName("windows-1251"));
            Files.write(Paths.get(pathTo), lines);
            return "Ok";
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    /**
     * Реализовать копирование больших файлов.
     */
    public static void copyBigFiles(String pathFrom, String pathTo) throws IOException {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathFrom), Charset.forName("windows-1251")))) {
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathTo), Charset.forName("windows-1251")))) {

                String str;
                while ((str = br.readLine()) != null) {
                    bw.write(str + "\n");
                }
            }
        }
    }
}
