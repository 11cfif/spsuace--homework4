package ru.spsuace.homework4.streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFile {

    /**
     * Реализовать копирование больших файлов через стримы.
     */
    public static void copyFile(String pathFrom, String pathTo) throws IOException {
        File out = new File(pathFrom);
        File to = new File(pathTo);

        Path inf = Paths.get(pathTo);
        Files.createDirectories(inf.getParent());
        try (BufferedInputStream bufferInputStream = new BufferedInputStream(new FileInputStream(out))) {
            try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(to))) {
                byte[] buff = new byte[1024];
                int len;
                while ((len = bufferInputStream.read(buff)) > 0) {
                    bufferedOutputStream.write(buff, 0, len);
                }
            }
        }
    }

    /**
     * Реализовать копирование из одной директории в другую
     */
    public static void copyDir(String pathFrom, String pathTo) throws IOException {

        File out = new File(pathFrom);
        File to = new File(pathTo);

        if (out.exists()) {
            if (out.isDirectory()) {
                if (!to.exists()) {
                    Files.createDirectories(Paths.get(to.toString()));
                }
                String[] allFiles = out.list();
                for (String s : allFiles) {
                    copyDir(new File(out, s).toString(), new File(to, s).toString());
                }
            } else {
                copyFile(pathFrom, pathTo);
            }
        }
    }
}

