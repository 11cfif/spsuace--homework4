package ru.spsuace.homework4.streams;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CopyFile {

    /**
     * Реализовать копирование маленьких файлов, через чтение и запись всех строк разом.
     * Если не получилось скопировать файл, то вернуть причину. Если получилось - вернуть "Ok"
     */
    public static String copySmallFiles(String pathFrom, String pathTo) throws Exception {

        String allString = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathFrom), "Cp1251"))) {
            String str;

            while ((str = br.readLine()) != null) {
                allString = allString + str + "\n";
            }
            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathTo), "Cp1251"))) {

                bw.write(allString);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return allString;
    }


    /**
     * Реализовать копирование больших файлов.
     */
    public static void copyBigFiles(String path) throws IOException {
    }

    public static void main(String[] arg) throws Exception {
        copySmallFiles("E:\\test.txt", "E:\\test1.txt");
        //System.out.println;
    }
}


