package ru.spsuace.homework4.streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

public class CopyFile {

    /**
     * Реализовать копирование больших файлов через стримы.
     */
    public static void copyFile(String pathFrom, String pathTo) throws IOException {
        Path inf = Paths.get(pathTo);
        Files.createDirectories(inf.getParent());
        BufferedInputStream bufferInputStream = new BufferedInputStream(new FileInputStream(pathFrom));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(pathTo));
        try {
            byte[] buff = new byte[1024];
            int len;
            while ((len = bufferInputStream.read(buff)) > 0) {
                bufferedOutputStream.write(buff, 0, len);
            }
        } finally {
            bufferInputStream.close();
            bufferedOutputStream.close();
        }
    }


    /**
     * Реализовать копирование из одной директории в другую
     */
    public static void copyDir(String pathFrom, String pathTo) throws IOException {

        File out = new File(pathFrom);
        File to = new File(pathTo);
        System.out.println(pathTo);
        if (out.exists()) {
            if(!to.exists()) {
                Files.createDirectories(Paths.get(to.toString()));
            }
            File[] allFiles = out.listFiles();
            for(File file : allFiles) {
                if (file.isDirectory()) {
                    copyDir(file.toString(), pathTo);
                    System.out.println(pathTo);
                    continue;
                } else {
                    continue;
                }
            }
        }
    }
}
