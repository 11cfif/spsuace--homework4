package ru.spsuace.homework4.streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {

    /**
     * Реализовать копирование маленьких файлов, через чтение и запись всех строк разом.
     * Если не получилось скопировать файл, то вернуть причину. Если получилось - вернуть "Ok"
     */
    public static String copySmallFiles(String pathFrom, String pathTo) {

        if (pathFrom == null || pathTo == null || pathFrom.isEmpty() || pathTo.isEmpty()) {
            return "NPE";
        }

        Path path = Paths.get(pathFrom);

        if (Files.exists(path)) {
            try {

                List<String> strings = Files.readAllLines(path);
                Path file = Paths.get(pathTo);

                if (Files.notExists(file)) {
                    Files.createFile(file);
                }

                Path writeFile = Paths.get(file.toString());
                try (BufferedWriter writer = Files.newBufferedWriter(writeFile)) {

                    for (int i = 0; i < strings.size(); i++) {
                        writer.write(strings.get(i) + "\n");
                    }

                    return "Ok";
                }

            } catch (Exception e) {
                return "failed";
            }
        }
        return "not such file";
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
