package com.javarush.flyagin.cryptoanalyzer.service;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {
    public static BufferedReader readFile(String path){
        Path file = Path.of(path);
        try(BufferedReader bufferedReader = Files.newBufferedReader(file)){
         return bufferedReader;
        }catch (IOException ex){
           throw new RuntimeException();
        }

    }
    public static void writeFile(String content, String path){
        try(FileWriter fileWriter = new FileWriter(path, Charset.forName("UTF-8"), true)) {
           fileWriter.write(content);
        }catch(IOException ex){
            throw new RuntimeException();
        }


    }
}
