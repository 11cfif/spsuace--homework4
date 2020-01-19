package ru.spsuace.homework4.streams;

import java.io.*;

public class CopyFile {

    /**
     * Реализовать копирование больших файлов через стримы.
     */
    public static void copyFile(String pathFrom, String pathTo) throws IOException {
        try(BufferedReader br = new BufferedReader (new FileReader(pathFrom));
            BufferedWriter bw = new BufferedWriter(new FileWriter(pathTo)))
        {
            String text;
            while(!((text = br.readLine()) == null)){
                bw.write(text + "\n");
            }
        }
        /*catch(IOException ex){
            System.out.println(ex.getMessage());
        }*/
    }


    /**
     * Реализовать копирование из одной директории в другую
     */
    public static void copyDir(String pathFrom, String pathTo) {
    }
}
