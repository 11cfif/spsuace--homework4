package ru.spsuace.homework4.streams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopyFile {

    /**
     * Реализовать копирование больших файлов через стримы.
     */
    public static void copyFile(String pathFrom, String pathTo) throws IOException {

        File in = new File(pathTo);
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
//        File from = new File(pathFrom);
//        File to = new File(pathTo);
//
//        if (to.isFile()){
//
//        }
    }
}
