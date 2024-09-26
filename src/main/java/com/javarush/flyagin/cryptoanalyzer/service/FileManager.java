package com.javarush.flyagin.cryptoanalyzer.service;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static BufferedReader readFile(String path){            //чтение  из файла
        Path file = Path.of(path);
        try{BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
         return bufferedReader;
        }catch (IOException ex){
           throw new RuntimeException();
        }

    }
    public static void writeFile(String content, String path){   //запись в файл
        try(FileWriter fileWriter = new FileWriter(path, Charset.forName("UTF-8"), true)) {
           fileWriter.write(content);
        }catch(IOException ex){
            throw new RuntimeException();
        }


    }
}
