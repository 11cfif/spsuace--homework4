package ru.spsuace.homework4.files;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Directories {


    /**
     * Реализовать рекурсивное удаление всех файлов и дерикторий из директороии по заданному пути.
     * Метод должен возвращать количество удаленных файла и директорий.
     * Если директории по существующему пути нет, то возвращаем 0.
     * Написать двумя способами. С использованием File
     */
    public static int removeWithFile(String path) {

        int countFiles = 0;
        final File mainFile = new File(path);

        if (mainFile.exists() && mainFile.isDirectory()) {
            File[] allFile = mainFile.listFiles();
            if (allFile != null) {
                for(File thisFile:allFile){
                    if(thisFile.isFile()){
                        thisFile.delete();
                        countFiles+=1;
                    }
                }
            } else {
                for (int i = 0; i < allFile.length; i++) {
                    if (allFile[i].isFile()) {
                        allFile[i].delete();
                        countFiles += 1;
                    }
                    if (allFile[i].isDirectory()) {
                        countFiles += removeWithFile(allFile[i].getPath());
                    }
                }
            }
           mainFile.delete();
            countFiles+=1;
        }else{
                return 0;
            }
        return countFiles;
    }


    /**
     * С использованием Path
     */
    public static int removeWithPath(String path1) {

        Path path = Paths.get(path1);

        if (Files.exists(path)) {
            try {
                List<Path> listPath = Files.walk(path)
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

                for (Path element : listPath) {
                    Files.deleteIfExists(element);
                }
                return listPath.size();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
        return 0;
    }
}
