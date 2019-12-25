package ru.spsuace.homework4.streams;

import java.io.*;

public class CopyFile {

    /**
     * Реализовать копирование больших файлов через стримы.
     */

    public static void copyFile(String pathFrom, String pathTo) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathFrom))) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathTo))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line + "\n");
                }
            }
        }
    }


    /**
     * Реализовать копирование из одной директории в другую
     */
    public static void copyDir(String pathFrom, String pathTo) {
    }
}
